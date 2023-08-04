package com.apirest.LibraryManager.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Year;

public record BooksRecordDTO(@NotBlank String bookName, @NotBlank String bookAuthor, @NotNull Year bookRelease) {
}
