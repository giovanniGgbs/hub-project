package fintech.dao.impl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fintech.dao.interfaces.ContaDAO;
import fintech.dao.interfaces.HistoricoTransacaoDAO;
import fintech.dao.interfaces.PessoaDAO;
import fintech.models.Conta;
import fintech.models.HistoricoTransacao;
import fintech.models.Pessoa;
import fintech.models.PessoaFisica;
import fintech.models.PessoaJuridica;
import fintech.models.SituacaoConta;
import fintech.models.TipoTransacao;

@Repository
public class ContaDAOImpl implements ContaDAO{

	public static final Logger LOG = LoggerFactory.getLogger(ContaDAOImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Autowired
	private HistoricoTransacaoDAO historicoTransacaoDAO;
	
	@Transactional
	public void criar(Conta conta) throws Exception {
		Pessoa pessoa = pessoaDAO.getById(conta.getPessoa().getId());
		if(pessoa == null)
			throw new Exception("Pessoa não encontrada");
			
		if(PessoaFisica.class.isInstance(pessoa)) {
			LOG.info("Pessoa do tipo Física");
			PessoaFisica pf = PessoaFisica.class.cast(pessoa);
			conta.setPessoa(pf);
		} else {
			LOG.info("Pessoa do tipo Jurídica");
			PessoaJuridica pj = PessoaJuridica.class.cast(pessoa);
			conta.setPessoa(pj);
		}			
		em.persist(conta);
	}
	
	@Transactional
	public void remover(Conta conta) throws Exception {
		Conta c = null;
		try {
			c = getById(conta.getId());
			if (c == null){
				throw new Exception("Conta não encontrada");
			} else {
				em.remove(c);
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível remover a conta");
		}
	}

	@Transactional
	public void update(Conta conta, Long id) throws Exception {
		
		Conta c = null;
		try {
			c = getById(conta.getId());
			if (c == null){
				throw new Exception("Conta não encontrada");
			} else {
				c = conta;
				em.merge(c);
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível atualizar os dados da conta");
		}
	}
	
	@Transactional
	public void transferirValor(Long origem, Long destino, Double valor) throws Exception {
		Conta contaOrigem = em.find(Conta.class, origem);
		if(contaOrigem.getSaldo() < 0)
			throw new Exception("Conta origem não tem salda para tranferir");

		if(contaOrigem.getSituacao() != SituacaoConta.ATIVA)
			throw new Exception("Conta origem não esta ativa");
		
		String sqlVerificaSeContaFilha = "select COUNT(*) from contapai_contafilhas cf where cf.fk_id_conta_filhas = :id";
		BigInteger verificaSeContaFilha =  (BigInteger) em.createNativeQuery(sqlVerificaSeContaFilha)
						.setParameter("id", destino)
						.getSingleResult();
		if(verificaSeContaFilha.intValue() == 0)
			throw new Exception("Conta Matriz não pode receber tranferencias de outras contas, apenas aportes.");

		String sqlVerificaEhFilha = "select cc.fk_id_conta_pai from contapai_contafilhas cc where cc.fk_id_conta_filhas = :id";
		BigInteger verificaEhFilha =  (BigInteger) em.createNativeQuery(sqlVerificaEhFilha)
						.setParameter("id", destino)
						.getSingleResult();
		
		if(verificaEhFilha.intValue() != origem.intValue())
			throw new Exception("Conta não é filha da conta origem. Transferência não pode ser realizada.");
		
		Conta contaDestino = em.find(Conta.class, destino);
		
		Double saldo = contaDestino.getSaldo() + valor;
		contaDestino.setSaldo(saldo);
		em.merge(contaDestino);
		
		saldo = contaOrigem.getSaldo() - valor;
		contaOrigem.setSaldo(saldo);
		em.merge(contaOrigem);		
		
		HistoricoTransacao historicoTransacao = new HistoricoTransacao();
		historicoTransacao.setDescricao("Transferencia efetuada da conta " + contaOrigem.getNome());
		historicoTransacao.setData(new Date());
		historicoTransacao.setConta(contaOrigem);
		historicoTransacao.setTipoTransacao(TipoTransacao.TRANSFERENCIA);
		historicoTransacaoDAO.criar(historicoTransacao);
		
		historicoTransacao = new HistoricoTransacao();
		historicoTransacao.setDescricao("Transferencia realizada para conta " + contaDestino.getNome());
		historicoTransacao.setData(new Date());
		historicoTransacao.setTipoTransacao(TipoTransacao.TRANSFERENCIA);
		historicoTransacao.setConta(contaDestino);
		historicoTransacaoDAO.criar(historicoTransacao);
	}
	
	@Transactional
	public void transacaoAporte(Long destino, Double valor) throws Exception {
		Conta conta = null; 				
		try {
			conta = (Conta) em.createQuery("SELECT c FROM Conta c WHERE c.id = :destino")
					.setParameter("destino", destino).getSingleResult();
		} catch (Exception e) {
			throw new Exception("Conta não encontrada");
		}
		
		if(conta.getSituacao() != SituacaoConta.ATIVA)
			throw new Exception("Conta origem não esta ativa");
		
		Double saldo = conta.getSaldo() + valor;
		conta.setSaldo(saldo);
		em.merge(conta);
		
		HistoricoTransacao historicoTransacao = new HistoricoTransacao();
		historicoTransacao.setDescricao("Transacao realizada na conta " + conta.getNome());
		historicoTransacao.setData(new Date());
		historicoTransacao.setConta(conta);
		historicoTransacao.setTipoTransacao(TipoTransacao.APORTE);
		historicoTransacao.setValorTransferencia(valor);
		historicoTransacao.setCodigoAporte(UUID.randomUUID().toString());
		
		historicoTransacaoDAO.criar(historicoTransacao);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Conta> listarTodos() {
		
		String sql = "SELECT c.nome, c.situacao, c.codigoApote FROM Conta c";
		return em.createQuery(sql).getResultList();
	}
	
	@Transactional(readOnly = true)
	public Conta getById(Long id){
		
		Conta conta = (Conta)  em.createQuery("SELECT c FROM Conta c WHERE c.id = :id")
				.setParameter("id", id).getSingleResult();
		
		return conta;
	}

	@Transactional
	public void transacaoEstorno(Long idTransacao) throws Exception {
		
		HistoricoTransacao ht;
		try {
			ht = historicoTransacaoDAO.getByIdTransacao(idTransacao);
			
		} catch (Exception e) {
			throw new Exception("Transação não encontrada");
		}
		
		Conta conta = ht.getConta();
		
		if(conta.getSituacao() != SituacaoConta.ATIVA){
			throw new Exception("Conta não esta ativa");
		}else{
			Double saldoAtualizado = conta.getSaldo();
			saldoAtualizado += ht.getValorTransferencia();
			conta.setSaldo(saldoAtualizado);
			update(conta, conta.getId());
		}
		
	}

	
}
