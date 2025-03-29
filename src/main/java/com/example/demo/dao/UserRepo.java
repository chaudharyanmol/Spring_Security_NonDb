package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Student;


public interface UserRepo extends JpaRepository<Student, Integer>{
	
	public Student findById(int id);
	

}
