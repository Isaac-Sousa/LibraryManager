package com.apirest.LibraryManager.domain.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;

    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String Username;

    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String adress;

    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String email;
}
