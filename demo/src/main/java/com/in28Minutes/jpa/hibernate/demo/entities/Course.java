package com.in28Minutes.jpa.hibernate.demo.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@NamedQueries(value= {
		@NamedQuery(name="get_all_Course", query="Select c from Course c"),
		@NamedQuery(name="get_all_with_name_JPA", query="Select c from Course c where name like '%JPA%'")
})
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	//Default constructor
	private Course(){};
	
	public Course(String name) {
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

	@Override
	public String toString() {
		return "Course [" + name + "]";
	}

	
	
	
}
