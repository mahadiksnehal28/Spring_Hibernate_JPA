package com.in28Minutes.jpa.hibernate.demo.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(value = EnumType.STRING)
	private reviewRating rating;
	
	private String description;
	
	@ManyToOne
	private Course course;
	//Default constructor
	
	@ManyToOne
	private Student student;
	
	private Review(){};
	
	public Review(reviewRating rating, String description ) {
		this.rating = rating;
		this.description = description;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	

	public reviewRating getRating() {
		return rating;
	}

	public void setRating(reviewRating rating) {
		this.rating = rating;
	}

	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating,description);
		
	}

	
	
	
}
