package com.apirest.LibraryManager.domain.models;

// import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String adress;

    @NotBlank
    @Size(min = 3, max = 35)
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Column(nullable = false)
    private String email;

    // @OneToMany(mappedBy = "usuario")
    // private List<AluguelModel> alugueis;
}
