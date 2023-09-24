package com.apirest.LibraryManager.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.LibraryManager.domain.models.Books;
import com.apirest.LibraryManager.domain.repositories.BooksRepository;
import com.apirest.LibraryManager.domain.service.BooksService;
import com.apirest.LibraryManager.exception.ResourceNotFoundException;

@Service
public class BooksServiceImpl implements BooksService{
    
    private final BooksRepository booksRepository;
   
    public BooksServiceImpl(BooksRepository booksRepository) {
        super();
        this.booksRepository = booksRepository;  
    }

    @Override
    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    @Override
    public Books createBook(Books book){
        return booksRepository.save(book);
    }

    @Override
    public Books updateBook(long BookId, Books bookRequest){
        Books book = booksRepository.findById(BookId)
                     .orElseThrow(()-> new ResourceNotFoundException("Not possible update this"));
        
        book.setBookname(bookRequest.getBookname());
        book.setBookauthor(bookRequest.getBookauthor());
        book.setBookrelease(bookRequest.getBookrelease());
        return booksRepository.save(book);             
    }

    @Override
    public void deleteBook(long BookId){
        Books book = booksRepository.findById(BookId)
                     .orElseThrow(()-> new ResourceNotFoundException("Not possible delete this"));
             
        booksRepository.delete(book);              
    }
    
}