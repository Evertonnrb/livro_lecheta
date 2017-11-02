package br.com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.domain.Response;

@Path("/test")
public class HelloResources {

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_HTML+";charset=utf-8")
	public String helloHtml() {
		return "<b>Produzindo html!</b>";
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String post() {
		return "Produzindo texto puro";
	}
	
	@GET
	@Consumes({MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	@Produces({MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public Response put() {
		return Response.Ok("Produzindo XML");
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response helloJson() {
		return Response.Ok("Respondendo com JSON");
	}
}
