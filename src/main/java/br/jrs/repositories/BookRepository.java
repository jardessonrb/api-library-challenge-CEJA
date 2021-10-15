package br.jrs.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.jrs.connectionfactory.ConnectionFactory;
import br.jrs.entities.Book;
import br.jrs.entities.BookCategory;
import br.jrs.interfaces.BookRepositoryInterface;

public class BookRepository implements BookRepositoryInterface{

	public boolean register(Book book) {
		EntityManager manager = ConnectionFactory.getEntityManager();
		manager.getTransaction().begin();
		manager.persist(book);
		manager.getTransaction().commit();
		manager.close();		
		
		return true;
	}

	public List<Book> findAll() {
		EntityManager manager = ConnectionFactory.getEntityManager();
		manager.getTransaction().begin();
		List<Book> books = manager.createQuery("from Book").getResultList();
		manager.close();		
	
		return books;
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
