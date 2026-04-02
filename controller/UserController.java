package com.Spring.Loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Loan.dto.UserDTO;
import com.Spring.Loan.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	 @Autowired
	    private UserService userService;

	    // Create User
	    @PostMapping
	    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
	        return userService.createUser(userDTO);
	    }

	    // Get All Users
	    @GetMapping
	    public List<UserDTO> getAllUsers() {
	        return userService.getAllUsers();
	    }
	}
