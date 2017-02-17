package com.cliente.Bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.FileUploadEvent;

import com.cliente.util.HibernateUtil;
import com.mysql.jdbc.Connection;
import com.sistema.dao.BaladaDAO;
import com.sistema.dao.ClienteDAO;
import com.sistema.domain.Balada;
import com.sistema.domain.Cliente;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private Cliente cliente;
	private List<Cliente> clientes;
	private List<Balada> baladas;

	public List<Balada> getBaladas() {
		return baladas;
	}

	public void setBaladas(List<Balada> baladas) {
		this.baladas = baladas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void salvar() {
		try {

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.merge(cliente);

			novo();
			cliente = new Cliente();

			BaladaDAO baladaDAO = new BaladaDAO();
			baladas = baladaDAO.listar("codigo");

			clientes = clienteDAO.listar();

			Messages.addGlobalInfo("Cliente Cadastrado Com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar o cliente");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {

			ClienteDAO clienteDAO = new ClienteDAO();
			clientes = clienteDAO.listar();
			// Organizando em ordem alfabetica por "nome" - sobrenome - etc //

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {

			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.excluir(cliente);

			clientes = clienteDAO.listar();

			Messages.addGlobalInfo("Cliente removido com  Sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Cliente");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {

			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar editar um cliente");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {

			cliente = new Cliente();

			BaladaDAO baladaDAO = new BaladaDAO();
			baladas = baladaDAO.listar("descricao");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as baladas");
			erro.printStackTrace();
		}
	}

	public void imprimir() {
		try {
			
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent

("formListagem:tabela");
			Map<String, Object> filtros = tabela.getFilters();

			String cliNome = (String) filtros.get("nome");
			String cliSobrenome = (String) filtros.get("sobreNome");

			String caminho = Faces.getRealPath("/reports/produto.jasper");

			Map<String, Object> parametros = new HashMap<>();
			if (cliNome == null) {
				parametros.put("Cliente_Nome", "%%");
			} else {
				parametros.put("Cliente_Sobrenome", "%" + cliSobrenome + "%");
			}
			if (cliSobrenome== null) {
				parametros.put("FORNECEDOR_DESCRICAO", "%%");
			} else {
				parametros.put("FORNECEDOR_DESCRICAO", "%" + cliNome + 

"%");
			}

			java.sql.Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, 

parametros, conexao);

			JasperPrintManager.printReport(relatorio, true);

} catch (JRException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}

}