package br.jrs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "code")
	private long code;
	
	@Column(name = "loan_date")
	private Date loanDate;
	
	@Column(name = "devolution_date")
	private Date devolutionDate;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "book_loans", 
		joinColumns = {@JoinColumn(name = "loan_code")},
		inverseJoinColumns = {@JoinColumn(name = "book_code")})
	private List<Book> books;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "client", referencedColumnName = "code", nullable = false)
	private Client client;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getDevolutionDate() {
		return devolutionDate;
	}

	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
