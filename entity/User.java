package com.Spring.Loan.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is required")
	private String name;

	@Email(message = "Invalid email")
	private String email;
	private String phone;
	// one user --> many Loans
	@JsonManagedReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Loan> loans;
	public User() {	}

	public User(Long id, String name, String email, String phone, List<Loan> loans) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.loans = loans;
	}

 public	Long getId() {
		return id;
	}

 public	void setId(Long id) {
		this.id = id;
	}

 public	String getName() {
		return name;
	}

 public	void setName(String name) {
		this.name = name;
	}

 public	String getEmail() {
		return email;
	}

 public	void setEmail(String email) {
		this.email = email;
	}

 public	String getPhone() {
		return phone;
	}

 public	void setPhone(String phone) {
		this.phone = phone;
	}

 public	List<Loan> getLoans() {
		return loans;
	}

 public	void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
	
}
