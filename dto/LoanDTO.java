package com.Spring.Loan.dto;

import com.Spring.Loan.entity.LoanStatus;

public class LoanDTO {
	 private Long id;
	    private Double amount;
	    private Double interestRate;
	    private Integer tenure;
	    private LoanStatus status;
	    private Long userId;

	    public LoanDTO() {}

	    public LoanDTO(Long id, Double amount, Double interestRate, Integer tenure, LoanStatus status, Long userId) {
	        this.id = id;
	        this.amount = amount;
	        this.interestRate = interestRate;
	        this.tenure = tenure;
	        this.status = status;
	        this.userId = userId;
	    }

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public Double getAmount() { return amount; }
	    public void setAmount(Double amount) { this.amount = amount; }

	    public Double getInterestRate() { return interestRate; }
	    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }

	    public Integer getTenure() { return tenure; }
	    public void setTenure(Integer tenure) { this.tenure = tenure; }

	    public LoanStatus getStatus() { return status; }
	    public void setStatus(LoanStatus status) { this.status = status; }

	    public Long getUserId() { return userId; }
	    public void setUserId(Long userId) { this.userId = userId; }
}
