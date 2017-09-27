package fintech.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fintech.models.Pessoa;

/**
 * This class is used to access data for the User entity. Repository annotation
 * allows the component scanning support to find and configure the DAO wihtout
 * any XML configuration and also provide the Spring exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the method.
 * If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class PessoaDAO {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Save the user in the database.
	 */
	public void create(Pessoa pessoa) {
		entityManager.persist(pessoa);
		return;
	}

	/**
	 * Delete the user from the database.
	 */
	public void delete(Pessoa pessoa) {
		if (entityManager.contains(pessoa))
			entityManager.remove(pessoa);
		else
			entityManager.remove(entityManager.merge(pessoa));
		return;
	}

	/**
	 * Return all the users stored in the database.
	 */
	@SuppressWarnings("unchecked")
	public List<Pessoa> getAll() {
		return entityManager.createQuery("from Pessoa").getResultList();
	}

	/**
	 * Return the user having the passed email.
	 */
	public Pessoa getByEmail(String nome) {
		return (Pessoa) entityManager.createQuery("from Pessoa where nome = :nome").setParameter("nome", nome)
				.getSingleResult();
	}

	/**
	 * Return the user having the passed id.
	 */
	public Pessoa getById(long id) {
		return entityManager.find(Pessoa.class, id);
	}

	/**
	 * Update the passed user in the database.
	 */
	public void update(Pessoa pessoa) {
		entityManager.merge(pessoa);
		return;
	}

}
