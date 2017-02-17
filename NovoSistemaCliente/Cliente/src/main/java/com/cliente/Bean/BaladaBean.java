package com.cliente.Bean;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.sistema.dao.BaladaDAO;
import com.sistema.dao.ClienteDAO;
import com.sistema.dao.PessoaDAO;
import com.sistema.dao.UsuarioDAO;
import com.sistema.domain.Balada;
import com.sistema.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class BaladaBean implements Serializable {

	private Balada balada;
	private List<Balada> baladas;

	public List<Balada> getBaladas() {
		return baladas;
	}

	public void setBaladas(List<Balada> baladas) {
		this.baladas = baladas;
	}

	public Balada getBalada() {
		return balada;
	}

	public void setBalada(Balada balada) {
		this.balada = balada;
	}

	public void novo() {
		balada = new Balada();

	}

	
	
	
	
	public void salvar() throws IOException {
		try {

			BaladaDAO baladaDAO = new BaladaDAO();
			baladaDAO.merge(balada);

			balada = new Balada();
			baladas = baladaDAO.listar("descricao");

			Messages.addGlobalInfo("Balada Salva com Sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar a salvar a Balada");
			erro.printStackTrace();
		}
	}

	
	

		
	@PostConstruct
	public void listar() {
		try {
			BaladaDAO baladaDAO = new BaladaDAO();
			baladas = baladaDAO.listar("descricao");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as baladas");
			erro.printStackTrace();
		}
	}
	

	
	
	
	
	
	
	

	
	public void excluir(ActionEvent evento) {
		try {

			balada = (Balada) evento.getComponent().getAttributes().get("baladaSelecionado");

			BaladaDAO baladaDAO = new BaladaDAO();
			baladaDAO.excluir(balada);

			baladas = baladaDAO.listar();

			Messages.addGlobalInfo("Balada removida com Sucesso");
			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a Balada");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		balada = (Balada) evento.getComponent().getAttributes().get("baladaSelecionado");
	}

	public void upload(FileUploadEvent evento) {
		try {
			UploadedFile arquivoUpload = evento.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			balada.setCaminho(arquivoTemp.toString());

			Messages.addGlobalInfo("Imagem salva com sucesso");

		} catch (IOException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar carregar a imagem");
			erro.printStackTrace();
		}
	}

}
