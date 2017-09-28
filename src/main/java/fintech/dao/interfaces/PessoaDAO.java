package fintech.dao.interfaces;

import java.util.List;

import fintech.models.Pessoa;

public interface PessoaDAO {
	public void criar(Pessoa pessoa) throws Exception;
	public void remover(String nome) throws Exception;
	public List<Pessoa> getAll() throws Exception;
	public Pessoa getByName(String nome) throws Exception;
	public Pessoa getById(Long id) throws Exception;
	public void update(Pessoa pessoa) throws Exception;
	public List<Pessoa> getAllJuridica() throws Exception;
}
