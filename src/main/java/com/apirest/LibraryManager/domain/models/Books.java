package com.apirest.LibraryManager.domain.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Books {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long BookId;

    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String Bookname;

    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String Bookauthor;

    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private Year Bookrelease;

}