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

import com.example.project1.models.Combustion;
import com.example.project1.services.ICombustionService;
/**
 * 
 * @author Luz D. Delgado
 *
 */
@Path("/combustion")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class CombustionController {

	public ICombustionService combustionService;
	/**
	 * CombustionCar Controller
	 * 
	 * @param combustionService service
	 */
	public CombustionController(ICombustionService combustionService) {
		this.combustionService = combustionService;
	}

	/**
	 * GET http://localhost:8080/api/combustion
	 * 
	 * @return response
	 */
	@GET
	public List<Combustion> findAll() {
		return combustionService.findAll();

	}

	/**
	 * GET 
	 * http://localhost:8080/api/combustion/1
	 * http://localhost:8080/api/combustion/2 
	 * http://localhost:8080/api/combustion/3
	 * 
	 * @param id Id
	 * @return response
	 */

	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {

		Combustion combustionCar = combustionService.findOne(id);
		if (combustionCar == null) {
			return Response.status(Response.Status.NOT_FOUND).build();

		} else {
			return Response.ok(combustionCar).build();
		}

	}

	/**
	 * GET http://localhost:8080/api/combustion/color/rojo
	 * http://localhost:8080/api/combustion/color/azul
	 * http://localhost:8080/api/combustion/color/gris-plateado
	 * 
	 * @param color color
	 * @return response
	 */

	@GET
	@Path("/color/{color}")
	public List<Combustion> findByColor(@PathParam("color") String color) {

		return combustionService.findByColor(color);
	}

	/**
	 * GET http://localhost:8080/api/combustion/doors/3 
	 * http://localhost:8080/api/combustion/doors/5
	 * 
	 * @param number numero de puertas
	 * @return response
	 */

	@GET
	@Path("/doors/{number}")
	public List<Combustion> findByDoorsNumber(@PathParam("number") int number) {

		return combustionService.findByDoorsNumber(number);
	}

	/**
	 * GET http://localhost:8080/api/combustion/nombre/Opel%20Corsa
	 * http://localhost:8080/api/combustion/nombre/Renault%205
	 * http://localhost:8080/api/combustion/nombre/Ford%20Fiesta
	 * 
	 * @param name nombre
	 * @return response
	 */

	@GET
	@Path("/nombre/{name}")
	public List<Combustion> findByName(@PathParam("name") String name) {

		return combustionService.findByName(name);
	}
	
	
	/**
     * POST http://localhost:8080/api/combustion
     * 
     * @param combustion combustion
     * @return response
     */
	@POST  //Crear nuevo coche de combustion
	public Response create(Combustion combustion){
        if (combustion.getId() != null) { // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Combustion result = combustionService.save(combustion);
        return Response.ok(result).build();
    }
	
	/**
     * PUT http://localhost:8080/api/combustion
     * 
     * @param combustion combustion
     * @return response
     */
	@PUT // ACTUALIZAR
    public Response update(Combustion combustion){
        if (combustion.getId() == null || combustion.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Combustion result = combustionService.save(combustion);
        return Response.ok(result).build();
    }
	
	/**
     * DELETE
     * http://localhost:8080/api/combustion/1
     * http://localhost:8080/api/combustion/2
     * 
     * @param id Id
     * @return response
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!combustionService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }
    
    /**
     * DELETE
     * http://localhost:8080/api/combustion
     * 
     * @return response
     */
    @DELETE
    public Response deleteAll(){
    	combustionService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }
}
