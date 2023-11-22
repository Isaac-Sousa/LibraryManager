package com.apirest.LibraryManager.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Editora")
public class Publish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long publishId;

    @Size(min = 5, max = 50)
    @Column(nullable = false)
    private String publishName;

    @Size(min = 3, max = 50)
    @Column(nullable = false)
    private String publishCity;
}
