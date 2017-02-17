package com.sistema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "Balada")
public class Balada extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String descricao;

	// @ Transiente nao deixa cria tabela //s
	
	@Transient
	private String caminho;
	
	
	@Transient
	public String getCaminho() {
		return caminho;
	}
	@Transient
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}