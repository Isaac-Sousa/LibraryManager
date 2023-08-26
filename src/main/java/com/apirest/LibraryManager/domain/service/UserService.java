package com.apirest.LibraryManager.domain.service;

import java.util.List;

import com.apirest.LibraryManager.domain.models.User;

public interface UserService {
    
	List<User> getAllUsers();

	User createUser(User user);

	User updateUser(long id, User user);

	void deleteUser(long id);
}
