package com.sistema.domain;

import java.math.BigDecimal;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {



	@ManyToOne
	@JoinColumn(nullable = false)
	private Balada balada;

	@ManyToOne
	public Balada getBalada() {
		return balada;
	}
	@ManyToOne
	public void setBalada(Balada balada) {
		this.balada = balada;
	}

	@Column(length = 80, nullable = false)
	private String nome;

	@Column(length = 80, nullable = false)
	private String sobrenome;

	@Column(length = 14, nullable = false)
	private String telefone;

	@Column(length = 80, nullable = false)
	private String rg;

	@Column(length = 80, nullable = false)
	private String email;

	@Temporal(TemporalType.DATE)
	private Date dtCadastro;

	@Temporal(TemporalType.DATE)
	private Date dtAniversario;
	
	@Column(nullable = false)
	private Character sexo;
	
	

	


	

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valor;
	
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	public Date getDtAniversario() {
		return dtAniversario;
	}
	public void setDtAniversario(Date dtAniversario) {
		this.dtAniversario = dtAniversario;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	
	
	
	
	
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	
}