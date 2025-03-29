package com.example.demo.entities;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.IdGeneratorType;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name ;
@Column(name = "Father_name")
private String fname;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}




}
