package com.sistema.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.sistema.domain.Balada;

public class BaladaDAOTest {

	@Test

	public void salvar() {

		Balada balada = new Balada();
		balada.setDescricao("MACACO");

		BaladaDAO baladaDAO = new BaladaDAO();
		baladaDAO.salvar(balada);

	}

	@Test
	@Ignore
	public void listar() {

		BaladaDAO bDao = new BaladaDAO();
		List<Balada> resultado = bDao.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Balada balada : resultado) {
			System.out.println(balada.getDescricao());
		}
	}

	@Test
	@Ignore
	
	public void buscar() {
		Long codigo = 2L;

		BaladaDAO bDao = new BaladaDAO();
		Balada balada = bDao.buscar(codigo);

		if (balada == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(balada.getCodigo() + " - " + balada.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 2L;
		BaladaDAO baladaDAO = new BaladaDAO();

		Balada balada = baladaDAO.buscar(codigo);

		if (balada == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			baladaDAO.excluir(balada);
			System.out.println("Registro removido:");
			System.out.println(balada.getCodigo() + " - " + balada.getDescricao());
		}
	}

	@Test
	@Ignore
	public void editar() {

		Long codigo = 3L;
		
		BaladaDAO baladaDAO = new BaladaDAO();
		Balada balada = baladaDAO.buscar(codigo);

		if (balada == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(balada.getCodigo() + " - " + balada.getDescricao());

			balada.setDescricao("PENELOPE");
			baladaDAO.editar(balada);

			System.out.println("Registro editado - Depois:");
			System.out.println(balada.getCodigo() + " - " + balada.getDescricao());
		}
	}

	
	@Test
	@Ignore
	public void merge() {

		Balada balada = new Balada();
		balada.setDescricao("PENELOPE");

		BaladaDAO baladaDAO = new BaladaDAO();
		baladaDAO.merge(balada);

	}

	
	
	
}
