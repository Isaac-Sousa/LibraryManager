package com.apirest.LibraryManager.app.controllers;

import com.apirest.LibraryManager.domain.dtos.BooksDto;
import com.apirest.LibraryManager.domain.models.Books;
import com.apirest.LibraryManager.domain.service.BooksService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/books")
@CrossOrigin(origins = "*")
@RestController
public class BooksController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    BooksService booksService;

    @PostMapping("/save")
    @ApiOperation(value = "Insert a book")
    public ResponseEntity<BooksDto> createBook(@RequestBody BooksDto booksDto) {

        Books bookRequest = modelMapper.map(booksDto, Books.class);
        Books booksModel = booksService.createBook(bookRequest);

        BooksDto booksResponse = modelMapper.map(booksModel, BooksDto.class);
        return new ResponseEntity<BooksDto>(booksResponse, HttpStatus.CREATED);

    }

    @GetMapping(value = "/list")
    @ApiOperation(value = "list all books")
    public List<BooksDto> getAllBook() {

        return booksService.getAllBooks().stream().map(booksModel -> modelMapper.map(booksModel, BooksDto.class))
                .collect(Collectors.toList());

    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "change a book")
    public ResponseEntity<BooksDto> updateBook(@PathVariable(name="id") long BookId, @RequestBody BooksDto booksDto ){
        Books booksRequest = modelMapper.map(booksDto, Books.class);
        Books books = booksService.updateBook(BookId, booksRequest);
        BooksDto booksResponse = modelMapper.map(books, BooksDto.class);
        return ResponseEntity.ok().body(booksResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete an book")
    public void deleteBook(@PathVariable(name = "id") long BookId){
        booksService.deleteBook(BookId);
    }
}