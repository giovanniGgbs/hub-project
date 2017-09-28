package fintech.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fintech.dao.interfaces.HistoricoTransacaoDAO;
import fintech.models.HistoricoTransacao;

@Repository
public class HistoricoTransacaoDAOImpl implements HistoricoTransacaoDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void criar(HistoricoTransacao historicoTransacao) {
		em.persist(historicoTransacao);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HistoricoTransacao> listarTodos() {
		String sql = "SELECT ht.descricao, ht.data FROM HistoricoTransacao ht";
		return em.createQuery(sql).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<HistoricoTransacao> listarPorConta(Long idConta) {
		String sql = "SELECT ht.descricao, ht.data FROM HistoricoTransacao ht WHERE ht.conta.id = :idConta";
		return em.createQuery(sql)
				.setParameter("idConta", idConta)
				.getResultList();
	}
	
	public HistoricoTransacao getByIdTransacao(Long idTransacao){
		String sql = "SELECT ht FROM HistoricoTransacao WHERE ht.id = :idTransacao";
		return (HistoricoTransacao) em.createQuery(sql).setParameter("", idTransacao).getSingleResult();
	}
	
}

