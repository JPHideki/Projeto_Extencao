package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.model.Cliente;


@Repository
@Transactional
public class ClienteDAO implements CRUD<Cliente, Long>{
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cliente searchID(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	public List<Cliente> lista() {
		javax.persistence.Query query = entityManager.createQuery("Select c FROM Cliente c");
		return (List<Cliente>) query.getResultList();
	}

	@Override
	public void insert(Cliente cliente) {
		entityManager.persist(cliente);
		
	}

	@Override
	public void update(Cliente cliente) {
		entityManager.merge(cliente);
		
	}

	@Override
	public void remove(Cliente cliente) {
		entityManager.remove(cliente);
		
	}

}
