package br.jrs.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	//Tombo do livro
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "number_register")
	private String numberRegister;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "caption")
	private String caption;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "year_edition")
	private int yearEdition;
	
	@ManyToOne
	private BookCategory category;
	
	@ManyToOne
	private Library library;
	
	public Library getLibrary() {
		return library;
	}
	
	@ManyToMany(mappedBy = "listBooks")
	@Column(name = "book_loans")
	private List<BookLoan> bookLoans;

	public void setLibrary(Library library) {
		this.library = library;
	}

	public BookCategory getCategory() {
		return category;
	}

	public void setCategory(BookCategory category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getYearEdition() {
		return yearEdition;
	}

	public void setYearEdition(int yearEdition) {
		this.yearEdition = yearEdition;
	}

	public String getNumberRegister() {
		return numberRegister;
	}

	public void setNumberRegister(String numberRegister) {
		this.numberRegister = numberRegister;
	}
	
	
	
	
}
