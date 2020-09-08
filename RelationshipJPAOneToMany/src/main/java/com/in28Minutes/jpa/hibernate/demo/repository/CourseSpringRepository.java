 package com.in28Minutes.jpa.hibernate.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28Minutes.jpa.hibernate.demo.entities.Course;

@RepositoryRestResource(path="course1")
public interface CourseSpringRepository extends JpaRepository<Course, Long>{

	List<Course> findByName(String name);
	
	Optional<Course> findById(Long Id);
}
