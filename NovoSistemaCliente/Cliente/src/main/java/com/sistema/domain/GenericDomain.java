package com.sistema.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass 
// O que MappesuperCLass faz ? Ele cria classe falando que essa classe nao corresponde uma tabela, 
//ela vai ser usado para gera outra tabelas, CODIGo vai ser chave primearia e sera injetado em outras tabelas
public class GenericDomain {

	private Long codigo;
	
	//criando tabela no banco
	

	// Dizendo que é Chave primaria @ ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @ Generetade Value = Auto Incremento
	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericDomain other = (GenericDomain) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}





	
	
	
	
	
}
