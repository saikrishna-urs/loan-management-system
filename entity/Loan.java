package com.Spring.Loan.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double amount;
	@Column(name = "interest_rate")
	private Double interestRate;
	private Integer tenure;

	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Loan() {

	}

	public Loan(Long id, Double amount, Double interestRate, Integer tenure, LoanStatus status, User user ) {

		this.id = id;
		this.amount = amount;
		this.interestRate =interestRate ;
		this.tenure = tenure;
		this.status = status;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestrate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public LoanStatus getStatus() {
		return status;
	}

	public void setStatus(LoanStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
