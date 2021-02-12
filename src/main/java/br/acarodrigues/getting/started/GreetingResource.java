package br.acarodrigues.getting.started;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//EndPoint 

@Path("/hello")
public class GreetingResource {

    private static final String TOKEN = "dev";

	@GET
    @Path("/html")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy - " + UUID.randomUUID().toString();
    }
	
	@GET
    @Path("/html/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("id") String id) {
        return "Hello RESTEasy - " + id;
    }
    
    @POST    
    @Produces (MediaType.APPLICATION_JSON)
    @Consumes (MediaType.APPLICATION_JSON)
    public String addHello(@HeaderParam("token") String hToken, @QueryParam("token") String aToken) {
    	String token = hToken != null ? hToken : aToken;
    	if (!TOKEN.equals(token)) {
    	 throw new RuntimeException("Não autorizado!");
    	}
    	 return "{\"key\": \"" + token+ "\"}";
    	
    }
    
}