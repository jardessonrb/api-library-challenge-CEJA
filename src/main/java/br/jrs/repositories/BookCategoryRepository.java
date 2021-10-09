package br.jrs.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.jrs.entities.BookCategory;
import br.jrs.interfaces.BookCategoryRepositoryInterface;

public class BookCategoryRepository implements BookCategoryRepositoryInterface{

	public boolean register(BookCategory category) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("library");
		EntityManager manager = managerFactory.createEntityManager();
		
		
		manager.getTransaction().begin();
		manager.persist(category);
		manager.getTransaction().commit();
		manager.close();		
		
		return true;
	}

}
