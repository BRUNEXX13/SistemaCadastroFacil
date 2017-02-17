package com.cliente.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

//http://localhost:8080/Financeiro/rest
@ApplicationPath("rest")
public class ClienteResourceConfig extends ResourceConfig {
	public ClienteResourceConfig() {
		packages("com.cliente.service");
	}
}
