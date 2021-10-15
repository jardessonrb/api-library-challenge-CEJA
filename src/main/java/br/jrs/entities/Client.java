package br.jrs.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.jrs.enums.EnumSituationClient;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "code")
	private long code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "situation_client")
	private EnumSituationClient situationClient;
	
	@OneToMany(cascade = CascadeType.MERGE)
	private List<BookLoan> bookLoans;
	
	public Client() {}
	
	public long getCode() {
		return code;
	}
	
	public void setCode(long code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public EnumSituationClient getSituationClient() {
		return situationClient;
	}

	public void setSituationClient(EnumSituationClient situationClient) {
		this.situationClient = situationClient;
	}
	
		

}
