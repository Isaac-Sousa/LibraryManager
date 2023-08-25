package com.apirest.LibraryManager.app.controllers;

import com.apirest.LibraryManager.domain.dtos.UserDto;
import com.apirest.LibraryManager.domain.models.UserModel;
import com.apirest.LibraryManager.domain.service.UserService;

import org.modelmapper.ModelMapper;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@CrossOrigin(origins = {"*"})
@RestController
public class UserController {
    
    @Autowired
	private ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @PostMapping("/save")
    @ApiOperation(value="Insere um usuário")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		// convert DTO to entity
		UserModel userRequest = modelMapper.map(userDto, UserModel.class);

		UserModel userModel = userService.createUser(userRequest);

		// convert entity to DTO
		UserDto userResponse = modelMapper.map(userModel, UserDto.class);

		return new ResponseEntity<UserDto>(userResponse, HttpStatus.CREATED);
	}

    @GetMapping("/list")
    @ApiOperation(value="Lista todos os usuários")
	public List<UserDto> getAllPosts() {

		return userService.getAllUsers().stream().map(userModel -> modelMapper.map(userModel, UserDto.class))
				.collect(Collectors.toList());
	}
}