package com.apirest.LibraryManager.domain.service;

import java.util.List;

import com.apirest.LibraryManager.domain.models.UserModel;

public interface UserService {
    
	List<UserModel> getAllUsers();

	UserModel createUser(UserModel userModel);
}
