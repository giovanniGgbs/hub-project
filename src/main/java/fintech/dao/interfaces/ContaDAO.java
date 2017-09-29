package fintech.dao.interfaces;

import java.util.List;

import fintech.models.Conta;

public interface ContaDAO {

	public void criar(Conta conta) throws Exception;
	public void remover(Long id) throws Exception;
	public void update(Conta conta, Long id) throws Exception;
	public Conta getById(Long id);
	public List<Conta> listarTodos() ;
	public void transferirValor(Long origem, Long destino, Double valor) throws Exception;
	public void transacaoAporte(Long destino, Double valor) throws Exception;
	public void transacaoEstorno(Long idTransacao) throws Exception; 
	
}
