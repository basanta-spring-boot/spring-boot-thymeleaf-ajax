package com.spring.ajax.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ajax.api.dao.UserRepository;
import com.spring.ajax.api.entity.MyResponse;
import com.spring.ajax.api.entity.User;

@RestController
public class UserController {
	@Autowired
	private UserRepository repository;

	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		repository.save(user);
		MyResponse<User> response = new MyResponse<>("success", user);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<Object> getUsers() {
		MyResponse<List<User>> response = new MyResponse<>("success", repository.findAll());
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
