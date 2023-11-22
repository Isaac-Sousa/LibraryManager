package com.apirest.LibraryManager.app.controllers;

import com.apirest.LibraryManager.domain.dtos.PublishDto;
import com.apirest.LibraryManager.domain.models.Publish;
import com.apirest.LibraryManager.domain.service.PublishService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/publish")
@CrossOrigin(origins = "*")
@RestController
public class PublishController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    PublishService publishService;

    @PostMapping("/save")
    @ApiOperation(value = "Insert a publish")
    public ResponseEntity<PublishDto> createPublish(@RequestBody PublishDto publishDto) {

        Publish publishRequest = modelMapper.map(publishDto, Publish.class);
        Publish publishModel = publishService.createPublish(publishRequest);

        PublishDto publishResponse = modelMapper.map(publishModel, PublishDto.class);
        return new ResponseEntity<PublishDto>(publishResponse, HttpStatus.CREATED);
    }
   @GetMapping(value = "/list")
    @ApiOperation(value = "list all publish")
    public List<PublishDto> getAllPublish() {

        return publishService.getAllPublish().stream().map(publishModel -> modelMapper.map(publishModel, PublishDto.class))
                .collect(Collectors.toList());

    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "change a publish")
    public ResponseEntity<PublishDto> updatePublish(@PathVariable(name="id") long PublishId, @RequestBody PublishDto publishDto ){
        Publish publishRequest = modelMapper.map(publishDto, Publish.class);
        Publish publish = publishService.updatePublish(PublishId, publishRequest);
        PublishDto publishResponse = modelMapper.map(publish, PublishDto.class);
        return ResponseEntity.ok().body(publishResponse);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete a publish")
    public void deletePublish(@PathVariable(name = "id") long PublishId){
        publishService.deletePublish(PublishId);
    }
}

