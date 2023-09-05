package com.apirest.LibraryManager.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.LibraryManager.domain.models.Books;

public interface BooksRepository extends JpaRepository<Books, Long>{
    
}