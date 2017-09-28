package fintech.dao.interfaces;

import java.util.List;

import fintech.models.Pessoa;

public interface PessoaDAO {
	public void create(Pessoa pessoa);
	public void delete(String nome);
	public List<Pessoa> getAll();
	public Pessoa getByName(String nome);
	public void update(Pessoa pessoa);
}
