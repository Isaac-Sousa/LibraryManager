package com.apirest.LibraryManager.domain.repositories;

import com.apirest.LibraryManager.domain.models.Publish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishRepository extends JpaRepository<Publish, Long> {
}
