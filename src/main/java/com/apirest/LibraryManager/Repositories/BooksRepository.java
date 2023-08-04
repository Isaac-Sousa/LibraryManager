package com.apirest.LibraryManager.Repositories;

import com.apirest.LibraryManager.Models.BooksModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BooksRepository extends JpaRepository<BooksModel, UUID> {
}
