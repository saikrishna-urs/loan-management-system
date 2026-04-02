package com.Spring.Loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.Spring.Loan.entity.Loan;
import com.Spring.Loan.entity.LoanStatus;
import com.Spring.Loan.entity.User;
import com.Spring.Loan.exception.ResourceNotFoundException;
import com.Spring.Loan.repository.LoanRepository;
import com.Spring.Loan.repository.UserRepository;

@Service
public class LoanService {
	@Autowired
	private LoanRepository loanRepo;

	@Autowired
	private UserRepository userRepo;

	// Applying Loan
	public Loan applyLoan(Long userId, Loan loan) {
		User user = userRepo.findById(userId)
				         .orElseThrow(() ->  new ResourceNotFoundException("user not Found"));

		loan.setUser(user);
		loan.setStatus(LoanStatus.PENDING);
		return loanRepo.save(loan);
	}

	// Approve Loan
	public Loan approveLoan(Long loanId) {
		Loan loan = loanRepo.findById(loanId)
				         .orElseThrow(() -> new ResourceNotFoundException("Loan  approved"));
		loan.setStatus(LoanStatus.APPROVED);
		return loanRepo.save(loan);
	}
	// Rejected Loan
	public Loan rejectLoan(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan Rejected"));

        loan.setStatus(LoanStatus.REJECTED);
        return loanRepo.save(loan);
    }
	// Loan Disbursement
    public Loan disburseLoan(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan got Disbursement"));

        loan.setStatus(LoanStatus.DISBURSED);
        return loanRepo.save(loan);
    }
   public Loan closeLoan(Long loanId) {
	   Loan loan =  loanRepo.findById(loanId)
			      .orElseThrow(()-> new ResourceNotFoundException("Loan term closed"));
	    loan.setStatus(LoanStatus.ClOSED);  
	    return loanRepo.save(loan);
   }
	  // Get All Loans
    public List<Loan> getAllLoans() {
        return loanRepo.findAll();
    }
    
    //Get Loans By status
    public List<Loan> getLoanByStatus(LoanStatus status){
    	return loanRepo.findByStatus(status);
    }
    public List<Loan> getfindByAmountGreaterThan(Double amount){
    	return loanRepo.findByAmountGreaterThan(amount);
    }

    
    
    
    
    
    
    //Emi calculation
    public double calculateEMI(double amount, double rate, int tenure) {
        double monthlyRate = rate / (12 * 100);
        return (amount * monthlyRate * Math.pow(1 + monthlyRate, tenure)) /
               (Math.pow(1 + monthlyRate, tenure) - 1);
    }
}
