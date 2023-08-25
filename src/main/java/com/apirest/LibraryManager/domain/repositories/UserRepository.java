package com.apirest.LibraryManager.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.LibraryManager.domain.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    
}
