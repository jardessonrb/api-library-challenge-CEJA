package br.jrs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
}
