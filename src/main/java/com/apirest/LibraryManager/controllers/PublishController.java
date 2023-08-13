package com.apirest.LibraryManager.controllers;

import com.apirest.LibraryManager.DTOs.PublishRecordDto;
import com.apirest.LibraryManager.models.PublishModel;
import com.apirest.LibraryManager.repositories.PublishReoisitory;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublishController {
    @Autowired
    PublishReoisitory publishReoisitory;

    @PostMapping("/publish")
    public ResponseEntity<PublishModel>savePublish(@RequestBody @Valid PublishRecordDto publishRecordDto){
        var publishModel = new PublishModel();
        BeanUtils.copyProperties(publishRecordDto, publishModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(publishReoisitory.save(publishModel));
    }
    @GetMapping("/publish")
    public ResponseEntity<List<PublishModel>> getAllPublish(){
        return ResponseEntity.status(HttpStatus.OK).body(publishReoisitory.findAll());
    }
}
