package com.in28Minutes.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28Minutes.jpa.hibernate.demo.entities.Course;
import com.in28Minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28Minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepo;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		studentRepo.studentSave();
		
	}

}
