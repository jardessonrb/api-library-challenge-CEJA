package br.jrs.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.jrs.entities.Book;
import br.jrs.interfaces.BookRepositoryInterface;
import br.jrs.repositories.BookRepository;

@Path("book")
public class BookController {
	
	BookRepositoryInterface bookRepository = new BookRepository();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerBook(Book book) {
		
		System.out.println("Book: "+book.getTitle()+" "+book.getAuthor());
		
		bookRepository.register(book);
		
		return Response.status(Status.CREATED).entity(book).build();
	}

}
