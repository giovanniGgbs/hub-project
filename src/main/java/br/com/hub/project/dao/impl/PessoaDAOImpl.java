package br.com.hub.project.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.hub.project.dao.PessoaDAO;
import br.com.hub.project.entity.Pessoa;

public class PessoaDAOImpl implements PessoaDAO {

	/**
	 * An EntityManager will be automatically injected from entityManagerFactory
	 * setup on DatabaseDriverConfig class
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Pessoa pessoa) {

		entityManager.persist(pessoa);

	}

	@Override
	public void update(Pessoa pessoa) {

		entityManager.merge(pessoa);

	}

	@Override
	public void remove(Pessoa pessoa) {

		if (entityManager.contains(pessoa)) {

			entityManager.remove(pessoa);

		} else {

			entityManager.remove(entityManager.merge(pessoa));

		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> findAll() {
		
		return entityManager.createQuery("from Pessoa").getResultList();
		
	}

	@Override
	public Pessoa findByName(String name) {

		return (Pessoa) entityManager.createQuery(
		        "from Pessoa where name = :name")
		        .setParameter("name", name)
		        .getSingleResult();
		
	}

}
