package com.Spring.Loan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Loan.dto.LoanDTO;
import com.Spring.Loan.entity.Loan;
import com.Spring.Loan.entity.LoanStatus;
import com.Spring.Loan.entity.User;
import com.Spring.Loan.exception.ResourceNotFoundException;
import com.Spring.Loan.mapper.LoanMapper;
import com.Spring.Loan.repository.LoanRepository;
import com.Spring.Loan.repository.UserRepository;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepo;

    @Autowired
    private UserRepository userRepo;

    // Apply Loan
    public LoanDTO applyLoan(Long userId, LoanDTO loanDTO) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Loan loan = LoanMapper.toEntity(loanDTO, user);
        loan.setStatus(LoanStatus.PENDING);

        loan = loanRepo.save(loan);

        return LoanMapper.toDTO(loan);
    }

    // Approve Loan
    public LoanDTO approveLoan(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setStatus(LoanStatus.APPROVED);
        loan = loanRepo.save(loan);

        return LoanMapper.toDTO(loan);
    }

    // Reject Loan
    public LoanDTO rejectLoan(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setStatus(LoanStatus.REJECTED);
        loan = loanRepo.save(loan);

        return LoanMapper.toDTO(loan);
    }

    // Disburse Loan
    public LoanDTO disburseLoan(Long loanId) {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setStatus(LoanStatus.DISBURSED);
        loan = loanRepo.save(loan);

        return LoanMapper.toDTO(loan);
    }

    // Close Loan
    public LoanDTO closeLoan(Long loanId) throws Exception {
        Loan loan = loanRepo.findById(loanId)
                .orElseThrow(() -> new Exception("Internal server closed"));

        loan.setStatus(LoanStatus.ClOSED);
        loan = loanRepo.save(loan);

        return LoanMapper.toDTO(loan);
    }

    // Get All Loans
    public List<LoanDTO> getAllLoans() {
        return loanRepo.findAll().stream()
                .map(LoanMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get Loans By Status
    public List<LoanDTO> getLoanByStatus(LoanStatus status) {
        return loanRepo.findByStatus(status).stream()
                .map(LoanMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get Loans By Amount > X
    public List<LoanDTO> getfindByAmountGreaterThan(Double amount) {
        return loanRepo.findByAmountGreaterThan(amount).stream()
                .map(LoanMapper::toDTO)
                .collect(Collectors.toList());
    }

    // EMI Calculation
    public double calculateEMI(double amount, double rate, int tenure) {
        double monthlyRate = rate / (12 * 100);
        return (amount * monthlyRate * Math.pow(1 + monthlyRate, tenure)) /
               (Math.pow(1 + monthlyRate, tenure) - 1);
    }
}
