package com.apirest.LibraryManager.domain.dtos;

import lombok.Data;

@Data
public class PublishDto {
    private long publishID;
    private String publishName;
    private String publishCity;
}
