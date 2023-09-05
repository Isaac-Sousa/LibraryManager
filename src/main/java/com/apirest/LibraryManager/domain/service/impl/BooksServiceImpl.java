package com.apirest.LibraryManager.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.LibraryManager.domain.models.Books;
import com.apirest.LibraryManager.domain.repositories.BooksRepository;
import com.apirest.LibraryManager.domain.service.BooksService;
import com.apirest.LibraryManager.exception.ResourceNotFoundException;

@Service
public class BooksServiceImpl implements BooksService{
    
    private final BooksRepository BooksRepository
   
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
    public Books updateBook(long id, Books bookRequest){
        Books book = booksRepository.findById(booksId)
                     .orElseThrow(()-> new ResourceNotFoundException("Not possible update this"));
        
        book.setBookname(bookRequest.getBookName());
        book.setBookauthor(bookRequest.getBookAuthor());
        book.setBookrelease(bookRequest.getBookRelease());
        return booksRepository.save(book);             
    }

    @Override
    public void deleteBook(long id){
        Books book = booksRepository.findById(booksId)
                     .orElseThrow(()-> new ResourceNotFoundException("Not possible delete this"));
             
        booksRepository.delete(book);              
    }
    
}