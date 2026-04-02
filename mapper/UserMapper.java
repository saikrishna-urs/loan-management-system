package com.Spring.Loan.mapper;

import java.util.stream.Collectors;

import com.Spring.Loan.dto.UserDTO;
import com.Spring.Loan.entity.User;

public class UserMapper {
	  // Entity → DTO
    public static UserDTO toDTO(User user) {
        if (user == null) return null;

        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPhone(),
                user.getLoans() != null
                        ? user.getLoans().stream()
                            .map(LoanMapper::toDTO)
                            .collect(Collectors.toList())
                        : null
        );
    }

    // DTO → Entity
    public static User toEntity(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        // NOTE: loans not set here (handled separately)
        return user;
    }
}
