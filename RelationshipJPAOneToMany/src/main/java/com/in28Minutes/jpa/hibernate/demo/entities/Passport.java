package com.in28Minutes.jpa.hibernate.demo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;

	private String number;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy="passport")
	private Student student; 
	
	//Default constructor
	public Passport(){};
	
	public Passport(String number) {
		this.number = number;
	}

	
	public String getnumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}
	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("Passport[%s]", number);
		
	}

	
	
	
}
