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

import com.Spring.Loan.entity.Loan;
import com.Spring.Loan.entity.LoanStatus;
import com.Spring.Loan.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // Apply Loan
    @PostMapping("/{userId}")
    public Loan applyLoan(@PathVariable Long userId,
                          @RequestBody Loan loan) {
        return loanService.applyLoan(userId, loan);
    }

    // Approve Loan
    @PutMapping("/approve/{loanId}")
    public Loan approveLoan(@PathVariable Long loanId) {
        return loanService.approveLoan(loanId);
    }

    // Reject Loan
    @PutMapping("/reject/{loanId}")
    public Loan rejectLoan(@PathVariable Long loanId) {
        return loanService.rejectLoan(loanId);
    }
    //close loan
    @PutMapping("/close/{loanId}")
    public Loan closeLoan(@PathVariable Long loanId) {
        return loanService.closeLoan(loanId);
    }

    // Get All Loans
    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    // Get Loans by Status
    @GetMapping("/status/{status}")
    public List<Loan> getLoansByStatus(@PathVariable LoanStatus status) {
        return loanService.getLoanByStatus(status);
    }
    @GetMapping("/amouny/{amount}")
    public List<Loan> getFindByAmount(@PathVariable double amount){
    	return loanService.getfindByAmountGreaterThan(amount);
    }
    
    @GetMapping("/emi")
    public double getEMI(@RequestParam double amount,
                         @RequestParam double rate,
                         @RequestParam int tenure) {
        return loanService.calculateEMI(amount, rate, tenure);
    }
   
}