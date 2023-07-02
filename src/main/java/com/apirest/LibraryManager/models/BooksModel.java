package com.apirest.LibraryManager.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;
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
}
