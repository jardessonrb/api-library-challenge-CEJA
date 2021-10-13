package br.jrs.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.jrs.entities.Book;
import br.jrs.entities.BookCategory;
import br.jrs.interfaces.BookCategoryRepositoryInterface;
import br.jrs.interfaces.BookRepositoryInterface;
import br.jrs.repositories.BookCategoryRepository;
import br.jrs.repositories.BookRepository;

@Path("book")
public class BookController {
	
	BookRepositoryInterface bookRepository = new BookRepository();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerBook(Book book) {
		
		System.out.println("Book: "+book.getTitle()+" "+book.getAuthor()+" "+book.getCategory().getDescription());
		
		bookRepository.register(book);
		
		return Response.status(Status.CREATED).entity(book).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll() {
		BookRepositoryInterface bookRepository = new BookRepository();
		
		List<Book> books = bookRepository.findAll();
		
		
		return Response.status(Status.CREATED).entity(books).build();
	}

}
