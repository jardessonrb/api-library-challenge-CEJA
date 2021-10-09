package br.jrs.controllers;

import javax.ws.rs.Consumes;
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

@Path("book-category")
public class BookCategoryController {
	
	BookCategoryRepositoryInterface categoryRepository = new BookCategoryRepository();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerBook(BookCategory bookCategory) {
		
		System.out.println("bookCategory: "+bookCategory.getDescription());
		
		categoryRepository.register(bookCategory);
		
		return Response.status(Status.CREATED).entity(bookCategory).build();
	}
}