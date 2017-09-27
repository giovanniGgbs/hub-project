package br.com.hub.project.dao;

import java.util.List;

import br.com.hub.project.entity.Conta;

/**
 * @author Giovanni Gonçalves Braga de Sousa
 * 
 * Public interface for DAO methos from entity Conta
 *
 */
public interface ContaDAO {
	
	public void create(Conta conta);
	public void update(Conta conta);
	public void remove(Conta conta);
	public List<Conta> findAll();
	public Conta findByName(String name);
	
}
