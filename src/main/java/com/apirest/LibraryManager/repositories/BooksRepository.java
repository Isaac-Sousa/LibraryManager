package com.apirest.LibraryManager.repositories;

import com.apirest.LibraryManager.models.BooksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface BooksRepository extends JpaRepository<BooksModel, UUID> {
}