package com.apirest.LibraryManager.repositories;


import com.apirest.LibraryManager.models.PublishModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublishRepository extends JpaRepository<PublishModel, UUID> {
}
