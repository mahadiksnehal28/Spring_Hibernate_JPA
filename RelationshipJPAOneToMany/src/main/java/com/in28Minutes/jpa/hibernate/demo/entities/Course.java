package com.in28Minutes.jpa.hibernate.demo.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;




@Entity
//@Cacheable
@SQLDelete(sql="update course set is_deleted=true where id=?")
@Where(clause="is_deleted=false")
@NamedQueries(value= {
		@NamedQuery(name="get_all_Course", query="Select c from Course c"),
		@NamedQuery(name="get_all_Course_JOINFETCH", query="Select c from Course c JOIN Fetch c.students s"), //solution for N+1 problem
		@NamedQuery(name="get_all_with_name_JPA", query="Select c from Course c where name like '%JPA%'")
})
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@OneToMany(mappedBy= "course")
	private List<Review> reviews;
	
	@ManyToMany(mappedBy="courses")	
	private List<Student> students= new ArrayList<>();
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	private Boolean isDeleted;
	
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

	
	
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	
	//@JsonIgnore
	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [" + name + "]";
	}

	@PreRemove
	public void preRemove_demo()
	{
		this.isDeleted=true;
	}
	
	@PostLoad
	public void postLoad_Demo()
	{
		System.err.println("PostLoad called");
	}
	
	@PrePersist
	public void prePersist_Demo()
	{
		System.err.println("prePersist_Demo called");
	}
	
	@PostPersist
	public void postPersist_Demo()
	{
		System.err.println("postPersist_Demo called");
	}
	
	@PostRemove
	public void postRemove_Demo()
	{
		System.err.println("postRemove_Demo called");
	}
	
	@PreUpdate
	public void PreUpdate_Demo()
	{
		System.err.println("postRemove_Demo called");
	}
	
	@PostUpdate
	public void PostUpdate_Demo()
	{
		System.err.println("PostUpdate called");
	}
}
