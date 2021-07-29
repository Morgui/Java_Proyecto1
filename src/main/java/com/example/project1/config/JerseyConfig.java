package com.example.project1.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Luz D. Delgado
 *
 */
@ApplicationPath("/api") // indica la ruta a la api
@Component
public class JerseyConfig extends ResourceConfig {

/**
 * Constructor Jersey
 */
	public JerseyConfig() {
		// super(); dice que no es necesario
		// declarar dónde estan las clases controladoras
		packages("com.example.project1.rest");// aquí hay que poner dentro la ruta al paquete rest

	}

}