package com.apirest.LibraryManager.controllers;

import com.apirest.LibraryManager.DTOs.BooksRecordDto;
import com.apirest.LibraryManager.models.BooksModel;
import com.apirest.LibraryManager.repositories.BooksRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BooksController {

    @Autowired
    BooksRepository booksRepository;

    @PostMapping("/api/v1/books")
    public ResponseEntity<BooksModel>saveBooks(@RequestBody @Valid BooksRecordDto booksRecordDto){
        var booksModel = new BooksModel();
        BeanUtils.copyProperties(booksRecordDto,booksModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(booksRepository.save(booksModel));
    }
    @ApiOperation(value = "Return an example")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Documentation working")})
    @GetMapping("/api/v1/books")
    public ResponseEntity<List<BooksModel>> getAllBooks(){
      return ResponseEntity.status(HttpStatus.OK).body(booksRepository.findAll());
    }
}
