package com.apirest.LibraryManager.domain.service;

import com.apirest.LibraryManager.domain.models.Publish;

import java.util.List;

public interface PublishService {
    List<Publish> getAllPublish();

    Publish createPublish(Publish publish);

    Publish updatePublish(long publishId, Publish publish);

    void deletePublish(long publishId);
}
