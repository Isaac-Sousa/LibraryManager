package com.apirest.LibraryManager.DTOs;

import jakarta.validation.constraints.NotBlank;

public record PublishRecordDto(@NotBlank String publishName,@NotBlank String publishCity) {

}
