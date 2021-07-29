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

import com.example.project1.models.Hibrido;
import com.example.project1.services.IHibridoService;
/**
 * 
 * @author Luz D. Delgado
 *
 */
@Path("/hibrido")
@Component
@Produces(MediaType.APPLICATION_JSON) // indica que devuelve o produce JSON
@Consumes(MediaType.APPLICATION_JSON) // indica que recibe o consume JSON
public class HibridoController {
	
	public IHibridoService hibridoService;
/**
 * HibridoCar Controller
 * @param hibridoService service
 */
	public HibridoController(IHibridoService hibridoService) {
		this.hibridoService = hibridoService;
	}

	/**
	 * GET http://localhost:8080/api/hibrido
	 * 
	 * @return response
	 */
	@GET
	public List<Hibrido> findAll() {
		return hibridoService.findAll();

	}

	/**
	 * GET 
	 * http://localhost:8080/api/hibrido/1
	 * http://localhost:8080/api/hibrido/2 
	 * http://localhost:8080/api/hibrido/3
	 * 
	 * @param id ID
	 * @return response
	 * 
	 */

	@GET
	@Path("{id}")
	public Response findOne(@PathParam("id") Long id) {

		Hibrido hibridoCar = hibridoService.findOne(id);
		if (hibridoCar == null) {
			return Response.status(Response.Status.NOT_FOUND).build();

		} else {
			return Response.ok(hibridoCar).build();
		}

	}

	/**
	 * GET http://localhost:8080/api/hibrido/color/azul
	 * http://localhost:8080/api/hibrido/color/pearl
	 * http://localhost:8080/api/hibrido/color/snow
	 * 
	 * @param color color
	 * @return response
	 */

	@GET
	@Path("/color/{color}")
	public List<Hibrido> findByColor(@PathParam("color") String color) {

		return hibridoService.findByColor(color);
	}

	/**
	 * GET http://localhost:8080/api/hibrido/doors/3 
	 * http://localhost:8080/api/hibrido/doors/5
	 * 
	 * @param number numero de puertas
	 * @return response
	 * 
	 */

	@GET
	@Path("/doors/{number}")
	public List<Hibrido> findByDoorsNumber(@PathParam("number") int number) {

		return hibridoService.findByDoorsNumber(number);
	}

	/**
	 * GET http://localhost:8080/api/hibrido/nombre/Kia%20Niro
	 * http://localhost:8080/api/hibrido/nombre/Toyota%20Yaris
	 * http://localhost:8080/api/hibrido/nombre/Hyundai%20Ioniq
	 * 
	 * @param name nombre
	 * @return response
	 */

	@GET
	@Path("/nombre/{name}")
	public List<Hibrido> findByName(@PathParam("name") String name) {

		return hibridoService.findByName(name);
	}
	
	
	/**
     * POST http://localhost:8080/api/hibrido
     * 
     * @param hibrido hibrido
     * @return response
     */
	@POST  //Crear nuevo coche de hibrido
	public Response create(Hibrido hibrido){
        if (hibrido.getId() != null) { // si ya tiene id quiere decir que es una actualización no creación
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Hibrido result = hibridoService.save(hibrido);
        return Response.ok(result).build();
    }
	
	/**
     * PUT http://localhost:8080/api/hibrido
     * 
     * @param hibrido hibrido
     * @return response
     */
	@PUT // ACTUALIZAR
    public Response update(Hibrido hibrido){
        if (hibrido.getId() == null || hibrido.getId() == 0) // si no tiene id quiere decir que es una creación no actualización
            return Response.status(Response.Status.BAD_REQUEST).build();
        
        Hibrido result = hibridoService.save(hibrido);
        return Response.ok(result).build();
    }
	
	/**
     * DELETE
     * http://localhost:8080/api/hibrido/1
     * http://localhost:8080/api/hibrido/2
     * 
     * @param id Id
     * @return response
     */
    @DELETE
    @Path("{id}")
    public Response deleteOne(@PathParam("id") Long id){
        if(!hibridoService.delete(id))
        	return Response.status(Response.Status.NOT_FOUND).build();
        
        return Response.ok(Response.Status.OK).build();
    }
    
    /**
     * DELETE
     * http://localhost:8080/api/hibrido
     * 
     * @return response
     */
    @DELETE
    public Response deleteAll(){
    	hibridoService.deleteAll();
        return Response.ok(Response.Status.OK).build();
    }

}
