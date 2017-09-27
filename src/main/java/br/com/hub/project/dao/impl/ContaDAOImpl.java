//package br.com.hub.project.dao.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//import br.com.hub.project.dao.ContaDAO;
//import br.com.hub.project.entity.Conta;
//
//public class ContaDAOImpl implements ContaDAO {
//
//	/**
//	 * An EntityManager will be automatically injected from entityManagerFactory setup on DatabaseDriverConfig class
//	 */
//	@PersistenceContext
//	private EntityManager entityManager;
//
//	@Override
//	public void create(Conta conta) {
//		entityManager.persist(conta);
//	}
//	
//	@Override
//	public void update(Conta conta) {
//		entityManager.merge(conta);
//	}
//
//	@Override
//	public void remove(Conta conta) {
//		
//		if (entityManager.contains(conta)) {
//			
//			entityManager.remove(conta);
//			
//		} else {
//			
//			entityManager.remove(entityManager.merge(conta));
//			
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Conta> findAll() {
//		
//		return entityManager.createQuery("from Conta").getResultList();
//		
//	}
//
//	@Override
//	public Conta findByName(String name) {
//		
//		return (Conta) entityManager.createQuery(
//		        "from Conta where name = :name")
//		        .setParameter("name", name)
//		        .getSingleResult();
//		
//	}
//
//}
