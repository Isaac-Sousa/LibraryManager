package com.apirest.LibraryManager.controllers;

import com.apirest.LibraryManager.DTOs.BooksRecordDto;
import com.apirest.LibraryManager.models.BooksModel;
import com.apirest.LibraryManager.repositories.BooksRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @PostMapping("/books")
    public ResponseEntity<BooksModel>saveBooks(@RequestBody @Valid BooksRecordDto booksRecordDto){
        var booksModel = new BooksModel();
        BeanUtils.copyProperties(booksRecordDto,booksModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(booksModel));
    }
}
