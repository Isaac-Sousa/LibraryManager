package com.apirest.LibraryManager.domain.dtos;

import lombok.Data;

@Data
public class BooksDto {
    
    private long booksId;
    private String Bookname;
    private String Bookauthor;
    private String BookRelease;
}
