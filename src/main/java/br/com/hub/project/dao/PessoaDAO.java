package br.com.hub.project.dao;

import java.util.List;

import br.com.hub.project.entity.Pessoa;

/**
 * @author Giovanni Gonçalves Braga de Sousa
 * 
 * Public interface for DAO methos from entity Pessoa
 *
 */
public interface PessoaDAO {
	
	public void create(Pessoa pessoa);
	public void update(Pessoa pessoa);
	public void remove(Pessoa pessoa);
	public List<Pessoa> findAll();
	public Pessoa findByName(String name);

}
