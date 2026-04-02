package com.Spring.Loan.mapper;

import com.Spring.Loan.dto.LoanDTO;
import com.Spring.Loan.entity.Loan;
import com.Spring.Loan.entity.User;

public class LoanMapper {
	 // Convert Entity → DTO
    public static LoanDTO toDTO(Loan loan) {
        if (loan == null) return null;

        return new LoanDTO(
                loan.getId(),
                loan.getAmount(),
                loan.getInterestRate(),
                loan.getTenure(),
                loan.getStatus(),
                loan.getUser() != null ? loan.getUser().getId() : null
        );
    }

    // Convert DTO → Entity
    public static Loan toEntity(LoanDTO dto, User user) {
        if (dto == null) return null;

        Loan loan = new Loan();
        loan.setId(dto.getId());
        loan.setAmount(dto.getAmount());
        loan.setInterestRate(dto.getInterestRate());
        loan.setTenure(dto.getTenure());
        loan.setStatus(dto.getStatus());
        loan.setUser(user);

        return loan;
    }
}
