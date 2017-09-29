package fintech.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Repository;

import fintech.dao.interfaces.PessoaDAO;
import fintech.models.Pessoa;

@Repository
@Transactional
public class PessoaDAOImpl implements PessoaDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void criar(Pessoa pessoa) {
		entityManager.persist(pessoa);
		return;
	}
	
	@Transactional
	public void remover(String nome) {
		
		Pessoa pessoa = getByName(nome);
		
		if (entityManager.contains(pessoa))
			entityManager.remove(pessoa);
		else
			entityManager.remove(entityManager.merge(pessoa));
		return;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Pessoa> getAll() {
		return entityManager.createQuery("from Pessoa").getResultList();
	}
	
	@Transactional(readOnly = true)
	public Pessoa getByName(String nome) {
		return (Pessoa) entityManager.createQuery("from Pessoa where nome = :nome").setParameter("nome", nome)
				.getSingleResult();
	}

	@Transactional
	public void update(Pessoa pessoa) {
		
		Pessoa p = getByName(pessoa.getNome());
		p = pessoa;
		if(entityManager.contains(p)){
			entityManager.merge(p);
		}
		
		return;
	}

	@Transactional(readOnly = true)
	public Pessoa getById(Long id) {
		return entityManager.find(Pessoa.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> getAllJuridica() {
		String tipo = "PF";
		return entityManager.createQuery("from Pessoa where tipo_pessoa = :tipo").setParameter("tipo", tipo).getResultList();
	}


}
