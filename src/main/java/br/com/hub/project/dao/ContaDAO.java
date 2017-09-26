package br.com.hub.project.dao;

import java.util.List;

import br.com.hub.project.entity.Conta;

public interface ContaDAO {
	
	public void create(Conta conta);
	public void remove(Conta conta, Long id);
	public List<Conta> findAll();
	public Conta findByName(String name);
	
}
