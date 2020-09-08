package com.in28Minutes.jpa.hibernate.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@Embedded
	private Address address;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	
	@OneToMany(mappedBy="student")
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name= "STUDENT_COURSE",
	joinColumns =@JoinColumn(name= "Student_Id"),
	inverseJoinColumns = @JoinColumn(name ="Course_Id"))
	private List<Course> courses =new ArrayList<>();;
	
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

	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course course) {
		this.courses.add(course);
	}
	
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review review) {
		this.reviews.add(review);
	}

	@Override
	public String toString() {
		return "Student [" + name + "]";
	}

	
	
	
}
