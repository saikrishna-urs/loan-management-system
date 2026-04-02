package com.Spring.Loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Loan.dto.LoanDTO;
import com.Spring.Loan.entity.LoanStatus;
import com.Spring.Loan.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

	 @Autowired
	    private LoanService loanService;

	    // Apply Loan
	    @PostMapping("/{userId}")
	    public LoanDTO applyLoan(@PathVariable Long userId,
	                             @RequestBody LoanDTO loanDTO) {
	        return loanService.applyLoan(userId, loanDTO);
	    }

	    // Approve Loan
	    @PutMapping("/approve/{loanId}")
	    public LoanDTO approveLoan(@PathVariable Long loanId) {
	        return loanService.approveLoan(loanId);
	    }

	    // Reject Loan
	    @PutMapping("/reject/{loanId}")
	    public LoanDTO rejectLoan(@PathVariable Long loanId) {
	        return loanService.rejectLoan(loanId);
	    }

	    // Close Loan
	    @PutMapping("/close/{loanId}")
	    public LoanDTO closeLoan(@PathVariable Long loanId) throws Exception {
	        return loanService.closeLoan(loanId);
	    }

	    // Get All Loans
	    @GetMapping
	    public List<LoanDTO> getAllLoans() {
	        return loanService.getAllLoans();
	    }

	    // Get Loans by Status
	    @GetMapping("/status/{status}")
	    public List<LoanDTO> getLoansByStatus(@PathVariable LoanStatus status) {
	        return loanService.getLoanByStatus(status);
	    }

	    // Get Loans by Amount
	    @GetMapping("/amount/{amount}")
	    public List<LoanDTO> getFindByAmount(@PathVariable Double amount) {
	        return loanService.getfindByAmountGreaterThan(amount);
	    }

	    // EMI Calculation
	    @GetMapping("/emi")
	    public double getEMI(@RequestParam double amount,
	                         @RequestParam double rate,
	                         @RequestParam int tenure) {
	        return loanService.calculateEMI(amount, rate, tenure);
	    }
   
}