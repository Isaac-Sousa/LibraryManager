package com.apirest.LibraryManager.Controllers;

import com.apirest.LibraryManager.Models.BooksModel;
import com.apirest.LibraryManager.DTOs.BooksRecordDTO;
import com.apirest.LibraryManager.Repositories.BooksRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    BooksRepository booksRepository;

    @PostMapping("/books")
    public ResponseEntity<BooksModel> saveBooks(@RequestBody @Valid BooksRecordDTO booksRecordDTO){
        var booksModel = new BooksModel();
        BeanUtils.copyProperties(booksRecordDTO,booksModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(booksModel));
    }
    @GetMapping("/books")
    public ResponseEntity<List<BooksModel>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(booksRepository.findAll());
    }
}
