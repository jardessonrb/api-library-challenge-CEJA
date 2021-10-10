package br.jrs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_loan")
public class BookLoan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private String code;
	
	@Column(name = "loan_date")
	private Date loanDate;
	
	@Column(name = "devolution_date")
	private Date devolutionDate;
	
	@ManyToMany
	@JoinTable(name = "book_loans", 
		joinColumns = {@JoinColumn(name = "loans_code")},
		inverseJoinColumns = {@JoinColumn(name = "book_code")})
	private List<Book> listBooks;
	
	@ManyToOne
	private Client client;
}
