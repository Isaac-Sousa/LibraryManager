package com.apirest.LibraryManager.controllers;

import com.apirest.LibraryManager.DTOs.PublishRecordDto;
import com.apirest.LibraryManager.models.PublishModel;
import com.apirest.LibraryManager.repositories.PublishRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublishController {

    @Autowired
    PublishRepository publishRepository;

    @PostMapping("/publish")
    public ResponseEntity<PublishModel>savePublish(@RequestBody @Valid PublishRecordDto publishRecordDto){
        var publishModel = new PublishModel();
        BeanUtils.copyProperties(publishRecordDto, publishModel); /*Converte de DTO para Model*/
        return ResponseEntity.status(HttpStatus.CREATED).body(publishRepository.save(publishModel));
    }
    @GetMapping("/publish")
    public ResponseEntity<List<PublishModel>> getAllPublish(){
          return ResponseEntity.status(HttpStatus.OK).body(publishRepository.findAll());
    }
   /* Ainda em estudo
   * @GetMapping("/publish/{id}")
   *  public ResponseEntity<Object>getOnePublish(@PathVariable(value = id)UUID id){
   *    Optional<PublishModel> publish0 = publishRepository.findById(id);
   *    if (publish0.isEmpty()){
   *      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("publish not found.");
   *    }
   *   return ResponseEntity.status(HttpStatus.OK).body(publish0.get());
   * }
   */


}
