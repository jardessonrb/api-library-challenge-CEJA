package br.jrs.interfaces;

import java.util.List;

import br.jrs.entities.BookCategory;

public interface BookCategoryRepositoryInterface {
	public boolean register(BookCategory category);
	public List<BookCategory> findAll();
	public BookCategory findById(long id);
}
