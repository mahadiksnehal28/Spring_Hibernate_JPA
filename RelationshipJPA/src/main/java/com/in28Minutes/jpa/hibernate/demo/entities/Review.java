package com.in28Minutes.jpa.hibernate.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;

	private String rating;
	
	private String description;
	
	
	//Default constructor
	private Review(){};
	
	public Review(String rating, String description ) {
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
	
	

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating,description);
		
	}

	
	
	
}
