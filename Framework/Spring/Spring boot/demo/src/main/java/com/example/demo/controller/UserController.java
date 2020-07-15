package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping("/all")
	public User getAll() {
		return service.getUser();
	}
}
