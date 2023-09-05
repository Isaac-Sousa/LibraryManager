package com.apirest.LibraryManager.domain.service;

import java.util.List;

import com.apirest.LibraryManager.domain.models.Books;

public interface BooksService{
    
    List<Books> getAllBooks();

    Books createBook(Books book);

    Books updateBook(long booksId, Books book);

    void deleteBook(long booksId);
}