package com.cliente.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

// http://localhost:8081/Cliente/rest/cliente
@Path("cliente")
public class ClienteService {
	@GET
	public String exibir(){
		return "Sistema Bruno Santos Silva";
	}
}