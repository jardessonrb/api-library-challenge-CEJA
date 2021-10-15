package br.jrs.controllers;

import java.util.List;

import javax.json.JsonObject;
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
import br.jrs.entities.Library;
import br.jrs.interfaces.BookCategoryRepositoryInterface;
import br.jrs.interfaces.BookRepositoryInterface;
import br.jrs.interfaces.LibraryRepositoryInterface;
import br.jrs.repositories.BookCategoryRepository;
import br.jrs.repositories.BookRepository;
import br.jrs.repositories.LibraryRepository;

@Path("book")
public class BookController {
	
	BookRepositoryInterface bookRepository = new BookRepository();
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerBook(JsonObject json) {
		
		BookCategoryRepositoryInterface bookCategoryRepository = new BookCategoryRepository();
		LibraryRepositoryInterface libraryRepository = new LibraryRepository();
		
//		Book book = new Book((long)json.getInt("numberRegister"), json.getString("title"), json.getString("caption"), json.getString("author"), json.getString("edition"), json.getInt("yearEdition"));
		
		Book book = new Book();
		BookCategory bookCategory = bookCategoryRepository.findById((long)json.getInt("category"));
		Library library = libraryRepository.findById((long)json.getInt("library"));
		
		
		book.setTitle(json.getString("title"));
		book.setCaption(json.getString("caption"));
		book.setAuthor(json.getString("author"));
		book.setEdition(json.getString("edition"));
		book.setYearEdition(json.getInt("yearEdition"));
		book.setCategory(bookCategory);
		book.setLibrary(library);
		System.out.println(bookCategory.getDescription()+" code "+bookCategory.getCode()+"\n"+library.getName()+" code "+library.getCode());
		
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
