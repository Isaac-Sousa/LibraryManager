package com.apirest.LibraryManager.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.LibraryManager.domain.models.User;
import com.apirest.LibraryManager.domain.repositories.UserRepository;
import com.apirest.LibraryManager.domain.service.UserService;
import com.apirest.LibraryManager.exception.ResourceNotFoundException;

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
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(long userId, User userRequest) {
		User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("Not possible update this"));
		
		user.setUsername(userRequest.getUsername());
		user.setAdress(userRequest.getAdress());
		user.setCity(userRequest.getCity());
		user.setEmail(userRequest.getEmail());
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(long userId) {
		User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("Not possible deleted this"));
		
		userRepository.delete(user);
	}
}
