package br.jrs.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.jrs.connectionfactory.ConnectionFactory;
import br.jrs.entities.BookCategory;
import br.jrs.interfaces.BookCategoryRepositoryInterface;

public class BookCategoryRepository implements BookCategoryRepositoryInterface{

	public boolean register(BookCategory category) {
		EntityManager manager = ConnectionFactory.getEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(category);
		manager.getTransaction().commit();
		manager.close();		
		
		return true;
	}
	
	
	public List<BookCategory> findAll(){
		EntityManager manager = ConnectionFactory.getEntityManager();
		
		manager.getTransaction().begin();
		List<BookCategory> bookCategories = manager.createQuery("from BookCategory").getResultList();
		
		manager.close();		
		
		return bookCategories;
	}

}
