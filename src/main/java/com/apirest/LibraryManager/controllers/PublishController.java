package com.apirest.LibraryManager.controllers;

import com.apirest.LibraryManager.DTOs.PublishRecordDto;
import com.apirest.LibraryManager.models.PublishModel;
import com.apirest.LibraryManager.repositories.PublishRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    PublishRepository publishRepository;

    @PostMapping("/publish")
    public ResponseEntity<PublishModel>savePublish(@RequestBody @Valid PublishRecordDto publishRecordDto){
        var publishModel = new PublishModel();
        BeanUtils.copyProperties(publishRecordDto, publishModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(publishRepository.save(publishModel));
    }
}
