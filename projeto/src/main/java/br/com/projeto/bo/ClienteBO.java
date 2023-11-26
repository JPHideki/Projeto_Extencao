package br.com.projeto.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.CRUD;
import br.com.projeto.dao.ClienteDAO;
import br.com.projeto.model.Cliente;

@Service
public class ClienteBO implements CRUD<Cliente, Long>{
	
	@Autowired
	private ClienteDAO dao;

	@Override
	public Cliente searchID(Long id) {
		return dao.searchID(id);
	}

	@Override
	public List<Cliente> lista() {
		return dao.lista();
	}

	@Override
	public void insert(Cliente cliente) {
		dao.insert(cliente);
		
	}

	@Override
	public void update(Cliente cliente) {
		dao.update(cliente);
		
	}

	@Override
	public void remove(Cliente cliente) {
		dao.remove(cliente);
		
	}
	
	public void desativar(Cliente cliente) {
		cliente.setAtivo(false);	
		dao.update(cliente);
		
	}
	
	public void ativar (Cliente cliente) {
		cliente.setAtivo(true);
		dao.update(cliente);
		
	}
	
	

}
