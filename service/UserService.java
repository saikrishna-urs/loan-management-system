package com.Spring.Loan.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Loan.dto.UserDTO;
import com.Spring.Loan.entity.User;
import com.Spring.Loan.mapper.UserMapper;
import com.Spring.Loan.repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepo;

	    // Create User
	    public UserDTO createUser(UserDTO userDTO) {
	        User user = UserMapper.toEntity(userDTO);
	        user = userRepo.save(user);
	        return UserMapper.toDTO(user);
	    }

	    // Get All Users
	    public List<UserDTO> getAllUsers() {
	        return userRepo.findAll().stream()
	                .map(UserMapper::toDTO)
	                .collect(Collectors.toList());
	    }
}
