package com.apirest.LibraryManager.domain.dtos;

import lombok.Data;

@Data
public class UserDto {
    
    private long id;
    private String Username;
    private String adress;
    private String city;
    private String email;
}
