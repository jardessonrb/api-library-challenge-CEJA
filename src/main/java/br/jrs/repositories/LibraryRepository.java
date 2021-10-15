package br.jrs.repositories;

import javax.persistence.EntityManager;

import br.jrs.connectionfactory.ConnectionFactory;
import br.jrs.entities.Library;
import br.jrs.interfaces.LibraryRepositoryInterface;

public class LibraryRepository implements LibraryRepositoryInterface{
	public Library findById(long id) {
		EntityManager manager = ConnectionFactory.getEntityManager();
		
		manager.getTransaction().begin();
		Library library = manager.find(Library.class, id);
		manager.getTransaction().commit();
		manager.close();
		
		return library;
	}
}
