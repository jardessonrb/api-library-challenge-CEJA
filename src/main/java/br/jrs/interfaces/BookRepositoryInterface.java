package br.jrs.interfaces;

import java.util.List;

import br.jrs.entities.Book;

public interface BookRepositoryInterface {
	public boolean register(Book book);
	public List<Book> find();
	public List<Book> findByName(String bookName);
	public Book findById(String numberRegister);
}
