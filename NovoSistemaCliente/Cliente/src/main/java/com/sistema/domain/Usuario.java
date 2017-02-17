package com.sistema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Usuario extends GenericDomain {

	@Column(length = 32, nullable = false)
	private String senha;

	@Transient
	private String senhaSemCriptografia;

	@Transient
	public String getSenhaSemCriptografia() {
		return senhaSemCriptografia;
	}

	@Transient
	public void setSenhaSemCriptografia(String senhaSemCriptografia) {
		this.senhaSemCriptografia = senhaSemCriptografia;
	}

	@Column(nullable = false)
	private Character tipo;

	@Column(nullable = false)
	private Boolean ativo;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	@ManyToOne
	public Pessoa getPessoa() {
		return pessoa;
	}

	@ManyToOne
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Character getTipo() {
		return tipo;
	}

	// informa que o campo nao pertence ao banco de dados
	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;

		if (tipo == 'A') {
			tipoFormatado = "Admnistrador";

		} else if (tipo == 'G') {
			tipoFormatado = "Gerente";

		} else if (tipo == 'U') {
			tipoFormatado = "Usuario";

		}
		return tipoFormatado;

	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	@Transient
	public String getAtivoFormatado() {
		String ativoformatado = "Não";
		if (ativo) {
			ativoformatado = "Sim";
		}
		return ativoformatado;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
