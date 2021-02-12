package br.acarodrigues.getting.started;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.acarodrigues.getting.started.service.GreetingService;

//EndPoint 

@Path("/hello")
public class GreetingResource {
		
	@Inject
	private GreetingService greetingService;

	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String hello(@QueryParam("name") String name) {
		return greetingService.sayHello(name);
    }

}