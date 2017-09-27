package br.com.hub.project.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.hub.project.dao.PessoaDAO;
import br.com.hub.project.entity.Pessoa;

@Repository
@Transactional
public class PessoaDAOImpl implements PessoaDAO {
	
	 @PersistenceContext
	 private EntityManager entityManager;
	
	@Override
	public void create(Pessoa pessoa) {
		 entityManager.persist(pessoa);
		 return;  
	}

	@Override
	public void update(Pessoa pessoa) {
		
	}

	@Override
	public void remove(Pessoa pessoa) {
		
	}

	@Override
	public List<Pessoa> findAll() {
		return null;
	}

	@Override
	public Pessoa findByName(String name) {
		return null;
	}


}
