package com.example.project1.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.project1.services.CarFactory;
/**
 * 
 * @author Luz D. Delgado
 *
 */
@Component
@Path("/car")
@Produces(MediaType.APPLICATION_JSON)
public class CarController {

	private final Logger log = LoggerFactory.getLogger(CarController.class);
	
	/**
	 * http://localhost:8080/api/car/Combustion
	 * http://localhost:8080/api/car/Electric
	 * http://localhost:8080/api/car/Hybrid
	 * 
	 * @param modelType modelo
	 * @return response
	 */
	
	@GET
	@Path("/{modelType}")
	public Response createByType(@PathParam("modelType") String modelType) {
		try {
			return Response.ok().entity(CarFactory.createByType(modelType)).build();
		} catch (Exception e) {
			log.error("Error trying to create a car by type.", e);
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
}
