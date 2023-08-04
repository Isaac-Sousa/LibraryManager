package com.apirest.LibraryManager.Models;

import jakarta.persistence.*;

import java.io.Serial;
import java.time.Year;
import java.util.UUID;

@Entity
@Table(name = "TB_BOOKS")
public class BooksModel {
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
