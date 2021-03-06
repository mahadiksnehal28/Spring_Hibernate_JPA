package com.in28Minutes.jpa.hibernate.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	
	//Default constructor
	public Student(){};
	
	public Student(String name) {
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	
	
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Override
	public String toString() {
		return "Student [" + name + "]";
	}

	
	
	
}
