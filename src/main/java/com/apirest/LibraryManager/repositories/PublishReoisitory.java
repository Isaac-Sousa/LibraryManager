package com.apirest.LibraryManager.repositories;

import com.apirest.LibraryManager.models.PublishModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublishReoisitory extends JpaRepository<PublishModel, UUID> {
}
