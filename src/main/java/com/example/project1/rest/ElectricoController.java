package com.example.project1.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.example.project1.models.Electrico;
import com.example.project1.services.IElectricoService;
/**
 * 
 * @author Luz D. Delgado
 *
 */
@Path("/electrico")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class ElectricoController {


	public IElectricoService electricoService;
	/**
	 * ElectricoCar Controller
	 * @param electricoService service
	 */
	public ElectricoController(IElectricoService electricoService) {
		this.electricoService = electricoService;
	}

	/**
	 * GET http://localhost:8080/api/electrico
	 * 
	 * @return response
	 */
	@GET
	public List<Electrico> findAll() {
		return electricoService.findAll();

	}

	/**
	 * GET 
	 * http://localhost:8080/api/electrico/1
	 * http://localhost:8080/api/electrico/2 
	 * http://localhost:8080/api/electrico/3
	 * 
	 * @param id ID
	 * @return response
	 */

	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {

		Electrico electricoCar = electricoService.findOne(id);
		if (electricoCar == null) {
			return Response.status(Response.Status.NOT_FOUND).build();

		} else {
			return Response.ok(electricoCar).build();
		}

	}

	/**
	 * GET http://localhost:8080/api/electrico/color/verde
	 * http://localhost:8080/api/electrico/color/negro
	 * http://localhost:8080/api/electrico/color/blanco
	 * 
	 * @param color color
	 * @return response
	 */

	@GET
	@Path("/color/{color}")
	public List<Electrico> findByColor(@PathParam("color") String color) {

		return electricoService.findByColor(color);
	}

	/**
	 * GET http://localhost:8080/api/electrico/doors/3 
	 * http://localhost:8080/api/electrico/doors/5
	 * 
	 * @param number numero de puertas
	 * @return response
	 */

	@GET
	@Path("/doors/{number}")
	public List<Electrico> findByDoorsNumber(@PathParam("number") int number) {

		return electricoService.findByDoorsNumber(number);
	}

	/**
	 * GET http://localhost:8080/api/electrico/nombre/Fiat%20500
	 * http://localhost:8080/api/electrico/nombre/Tesla
	 * http://localhost:8080/api/electrico/nombre/Nissan%20Leaf
	 * 
	 * @param name nombre
	 * @return response
	 */

	@GET
	@Path("/nombre/{name}")
	public List<Electrico> findByName(@PathParam("name") String name) {

		return electricoService.findByName(name);
	}
	
	
	/**
     * POST http://localhost:8080/api/electrico
     * 
     * @param electrico electrico
     * @return response
     */
	@POST  //Crear nuevo coche de electrico
	public Response create(Electrico electrico){
        if (electrico.getId() != null) { // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Electrico result = electricoService.save(electrico);
        return Response.ok(result).build();
    }
	
	/**
     * PUT http://localhost:8080/api/electrico
     * 
     * @param electrico electrico
     * @return response
     */
	@PUT // ACTUALIZAR
    public Response update(Electrico electrico){
        if (electrico.getId() == null || electrico.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Electrico result = electricoService.save(electrico);
        return Response.ok(result).build();
    }
	
	/**
     * DELETE
     * http://localhost:8080/api/electrico/1
     * http://localhost:8080/api/electrico/2
     * 
     * @param id Id
     * @return response
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!electricoService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }
    
    /**
     * DELETE
     * http://localhost:8080/api/electrico
     * 
     * @return response
     */
    @DELETE
    public Response deleteAll(){
    	electricoService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
}
