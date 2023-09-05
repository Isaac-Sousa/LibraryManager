package com.apirest.LibraryManager.domain.dtos;

import lombok.Data;

@Data
public class BooksDto {
    
    private long id;
    private String Bookname;
    private String Bookauthor;
    private String BookRelease;
}
