package com.apirest.LibraryManager.domain.service.impl;

import com.apirest.LibraryManager.domain.service.PublishService;
import com.apirest.LibraryManager.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.apirest.LibraryManager.domain.models.Publish;
import com.apirest.LibraryManager.domain.repositories.PublishRepository;

import java.util.List;

@Service
public class PublishServiceImpl implements PublishService {

      private final PublishRepository publishRepository;

    public PublishServiceImpl(PublishRepository publishRepository) {
        super();
        this.publishRepository = publishRepository;
    }

    @Override //GetAll
    public List<Publish> getAllPublish(){return publishRepository.findAll();}

    @Override //Create
    public Publish createPublish(Publish publish) {return publishRepository.save(publish);}

    @Override //Update
    public Publish updatePublish(long publishId, Publish publishRequest) {
        Publish publish = publishRepository.findById(publishId)
                .orElseThrow(() ->new ResourceNotFoundException("Not Possible update this"));
        publish.setPublishName(publishRequest.getPublishName());
        publish.setPublishCity(publishRequest.getPublishCity());
        return publishRepository.save(publish);
    }

    @Override //Delete
    public void deletePublish(long publishId) {
      Publish publish = publishRepository.findById(publishId)
             .orElseThrow(() -> new ResourceNotFoundException("Not possible delete this"));
      publishRepository.delete(publish);
    }


}
