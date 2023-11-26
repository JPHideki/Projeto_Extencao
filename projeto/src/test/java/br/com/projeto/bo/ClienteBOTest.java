package br.com.projeto.bo;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.projeto.model.Cliente;
import br.com.projeto.model.Sexo;



@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
public class ClienteBOTest {
	
	@Autowired
	private ClienteBO bo;
	
	
	
	@Test
	@Order(1)
	public void insert() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Juliano Hideki");
		cliente.setDataNascimento(LocalDate.of(2000, 02, 25));
		cliente.setCpf("000000000");
		cliente.setCelular("999999999");
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setEmail("a@a.com");
		cliente.setAtivo(true);
		bo.insert(cliente);
		
	}
	
	@Test
	@Order(2)
	public void searchID() {
		Cliente cliente = bo.searchID(1L);
		System.out.println(cliente);
	}
	@Test
	@Order(3)
	public void update() {
		Cliente cliente = bo.searchID(1L);
		cliente.setCpf("11111111111");
		bo.update(cliente);
		
	}
	@Test
	@Order(4)
	public void lista() {
		List<Cliente> clientes = bo.lista();
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}
	@Test
	@Order(5)
	public void inativa() {
		Cliente cliente = bo.searchID(1L);
		bo.desativar(cliente);
	}
	@Test
	@Order(6)
	public void remove() {
		Cliente cliente = bo.searchID(1L);
		bo.remove(cliente);
		
		
	}
	
	
	
}
