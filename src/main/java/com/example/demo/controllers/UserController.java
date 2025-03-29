package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/saveall")
	@PreAuthorize("hasRole('USER')")
	public Student save(@RequestBody Student s) {
		 return this.service.saveAll(s);
		
	}
	
	
	
	@GetMapping("/findAll")
	public List<Student> findAll(){
		
		List<Student> s = this.service.findAll();
		return s;
		
	}
	
	
	
	@GetMapping("/find/{id}")
	public Student findById(@PathVariable("id") int id) {
		return this.service.findById(id);
		
	}
	
	
	@GetMapping("/home")
	public String home() {
		return " hi i am home page";
	}
	
	

}
