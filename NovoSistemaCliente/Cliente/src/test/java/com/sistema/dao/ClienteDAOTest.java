package com.sistema.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.sistema.domain.Balada;
import com.sistema.domain.Cliente;

public class ClienteDAOTest {

	@Test

	public void salvar() throws ParseException { {
	
		BaladaDAO baladaDAO = new BaladaDAO();
		Balada balada = baladaDAO.buscar(new Long("2"));
		
			Cliente cliente = new Cliente();
			cliente.setNome("MARIO");
			cliente.setSobrenome("Dias");
			cliente.setTelefone("(11)94211-8201");
			cliente.setEmail("bruno@gmail.com");
			cliente.setRg("437007571");
			cliente.setDtCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2016"));
			cliente.setValor(new BigDecimal("11.50"));
			cliente.setBalada(balada);
	
		
			
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.salvar(cliente);
			
			System.out.println("Produto salvo com sucesso");
	}
	}

	@Test
	@Ignore
	public void listar() {

		ClienteDAO cDao = new ClienteDAO();
		List<Cliente> resultado = cDao.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Cliente cliente : resultado) {
			System.out.println(cliente.getNome() + "- " + cliente.getSobrenome() + " - " + cliente.getTelefone() + " - "
					+ cliente.getRg() + " - " + cliente.getEmail() + " - " + cliente.getDtCadastro() + " - "
					+ cliente.getValor() + " Nome da Balada " + cliente.getBalada());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ClienteDAO cDao = new ClienteDAO();
		Cliente cliente = cDao.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(
					cliente.getCodigo() + " NOME : " + cliente.getNome() + " SOBRENOME :  " + cliente.getSobrenome()
							+ " - " + cliente.getTelefone() + " - " + cliente.getRg() + " - " + cliente.getEmail()
							+ " - " + cliente.getDtCadastro() + " - " + cliente.getValor() + " - " + cliente.getBalada());
		}
	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			clienteDAO.excluir(cliente);
			System.out.println("Registro removido:");
			System.out.println(cliente.getNome() + "- " + cliente.getSobrenome() + " - " + cliente.getTelefone() + " - "
					+ cliente.getRg() + " - " + cliente.getEmail() + " - " + cliente.getDtCadastro() + " - "
					+ cliente.getValor());

		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {

		Long codigo = 1L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(cliente.getNome() + "- " + cliente.getSobrenome() + " - " + cliente.getTelefone() + " - "
					+ cliente.getRg() + " - " + cliente.getEmail() + " - " + cliente.getDtCadastro() + " - "
					+ cliente.getValor());

		}
		cliente.setNome("SHIRLEI");
		cliente.setSobrenome("RAIO LAISER");
		cliente.setTelefone("(11)94211-8201");
		cliente.setRg("43700757");
		cliente.setEmail("raiolaiser@gmail.com");
		cliente.setDtCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2016"));
		cliente.setValor(new BigDecimal("13,50"));
		clienteDAO.editar(cliente);

		System.out.println("Registro editado - Depois:");
		System.out.println(cliente.getNome() + "- " + cliente.getSobrenome() + " - " + cliente.getTelefone() + " - "
				+ cliente.getRg() + " - " + cliente.getEmail() + " - " + cliente.getDtCadastro() + " - "
				+ cliente.getValor());

	}

}
