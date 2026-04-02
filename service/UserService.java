package com.Spring.Loan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Loan.entity.User;
import com.Spring.Loan.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User createuser(User user) {
		return userRepo.save(user);
	}

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
}
