package br.jrs.repositories;

import javax.persistence.EntityManager;
import java.util.List;
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
	
	public BookCategory findById(long id){
		EntityManager manager = ConnectionFactory.getEntityManager();
		
		manager.getTransaction().begin();
		BookCategory bookCategory = manager.find(BookCategory.class, id);
		manager.getTransaction().commit();
		manager.close();		
		
		System.out.println("Categoria: "+bookCategory.getDescription());
		
		return bookCategory;
	}

}
