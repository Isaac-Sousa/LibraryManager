package com.apirest.LibraryManager.models;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.io.Serial;
import java.io.Serializable;
import java.time.Year;
import java.util.UUID;


public class BooksModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idBook;
    private String bookName;
    private String bookAuthor;
    private Year bookRelease;

    public UUID getIdBook() {
        return idBook;
    }

    public void setIdBook(UUID idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Year getBookRelease() {
        return bookRelease;
    }

    public void setBookRelease(Year bookRelease) {
        this.bookRelease = bookRelease;
    }
}
