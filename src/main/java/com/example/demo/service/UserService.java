package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.entities.Student;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo ;
	
	
	public Student saveAll(Student s) {
		    Student st=  this.repo.save(s);
		    return st;
	}
	
	
	public List<Student> findAll(){
		return this.repo.findAll();
	}
	
	
	public Student findById(int id) {
		return this.repo.findById(id);
	}
	

}
