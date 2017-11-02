package br.com.rest;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.domain.Carro;
import br.com.domain.Response;
import br.com.service.CarroService;

@Path("/carro")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")	
public class CarroResources {

	private CarroService carroService = new CarroService();

	@GET
	public List<Carro> get() {
		List<Carro> carros = carroService.getCarros();
		return carros;
	}
	
	@GET
	@Path("{id}")
	public Carro get(@PathParam("id") Long id) {
		Carro c = carroService.getCarro(id);
		return c;
	}
	
	@GET
	@Path("/tipo/{tipo}")
	public List<Carro> getByTipo(@PathParam("tipo") String tipo){
		List<Carro> carros = carroService.findByType(tipo);
		return carros;
	}
	
	@GET
	@Path("/nome/{nome}")
	public List<Carro> findByNome(@PathParam("nome") String nome){
		List<Carro> c = carroService.findByName(nome);
		return c;
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
				carroService.delete(id);
				return Response.Ok("carro deletado com sucesso");
	}
	
	@POST
	public Response post(Carro c) {
		carroService.save(c);
		return Response.Ok("Carro salvo com sucesso");
	}
	
	@PUT
	public Response put(Carro c) {
		carroService.save(c);
		return Response.Ok("Carro atualizado com sucesso");
	}
	
	

}
