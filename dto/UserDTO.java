package com.Spring.Loan.dto;

import java.util.List;

public class UserDTO {
	 private Long id;
	 
	    private String name;
	    private String email;
	    private String phone;
	    private List<LoanDTO> loans;

	    public UserDTO() {}

	    public UserDTO(Long id, String name, String email, String phone, List<LoanDTO> loans) {
	        this.id = id;
	        this.name = name;
	        this.email = email;
	        this.phone = phone;
	        this.loans = loans;
	    }

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }

	    public List<LoanDTO> getLoans() { return loans; }
	    public void setLoans(List<LoanDTO> loans) { this.loans = loans; }
}
