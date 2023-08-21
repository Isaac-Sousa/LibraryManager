package com.apirest.LibraryManager.DTOs;

import jakarta.validation.constraints.NotBlank;

public record UserRecordDto(@NotBlank String nameUser, @NotBlank String adressUser, @NotBlank String cityUser, @NotBlank String emailUser) { }
