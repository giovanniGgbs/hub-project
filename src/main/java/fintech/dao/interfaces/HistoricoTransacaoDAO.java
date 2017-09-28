package fintech.dao.interfaces;

import java.util.List;

import fintech.models.HistoricoTransacao;

public interface HistoricoTransacaoDAO {

	public void criar(HistoricoTransacao historicoTransacao);
	public List<HistoricoTransacao> listarTodos();
	public List<HistoricoTransacao> listarPorConta(Long idConta);
	public HistoricoTransacao getByIdTransacao(Long idTransacao);
	
}
