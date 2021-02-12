package br.acarodrigues.getting.started;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.netty.util.internal.StringUtil;



@Path("/book")
public class BookResource {
	
	//O resource será basicamente como um proxy não deve conter nele lógica de negócio
	
	private static List<String> books = new ArrayList<>();
	
	static {
		books.add("Livro 1");
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getBooks() {
		
		return StringUtil.join(" , ", books).toString();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addBook(String book) {
		books.add(book);
		return book;
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateBook(@PathParam("id") int index, String book) {
		
		books.remove(index);
		books.add(index,book);
		return book;
		
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBook(@PathParam("id") int index) {		
		return books.remove(index);			
	}
	

}
