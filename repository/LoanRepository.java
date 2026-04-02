package com.Spring.Loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.Loan.entity.Loan;
import com.Spring.Loan.entity.LoanStatus;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findByStatus(LoanStatus status);
	List<Loan> findByAmountGreaterThan(Double amount);

}
