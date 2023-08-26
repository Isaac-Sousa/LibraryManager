package com.apirest.LibraryManager.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.LibraryManager.domain.models.User;
import com.apirest.LibraryManager.domain.repositories.UserRepository;
import com.apirest.LibraryManager.domain.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

    @Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User createUser(User userModel) {
		return userRepository.save(userModel);
	}
}
