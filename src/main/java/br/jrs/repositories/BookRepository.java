package br.jrs.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.jrs.entities.Book;
import br.jrs.entities.BookCategory;
import br.jrs.interfaces.BookRepositoryInterface;

public class BookRepository implements BookRepositoryInterface{

	public boolean register(Book book) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("library");
		EntityManager manager = managerFactory.createEntityManager();
		
		manager.getTransaction().begin();
		BookCategory category = manager.find(BookCategory.class, 1L);
		book.setCategory(category);
		manager.persist(book);
		manager.getTransaction().commit();
		manager.close();		
		
		return true;
	}

	public List<Book> find() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> findByName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}


	public Book findById(String numberRegister) {
		// TODO Auto-generated method stub
		return null;
	}

}
