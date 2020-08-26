package com.in28Minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;
import com.in28Minutes.jpa.hibernate.demo.entities.Course;

@SpringBootTest(classes=DemoApplication.class)
class CourseDemoTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;
	
	
	@Test
	void findById_Test() {
		System.err.println("Test");
		Course course = courseRepo.findById(10001L);
		assertEquals("jpa in 50 steps",course.getName() );
	}


	@Test
	@DirtiesContext
	void DeleteById_Test() {
		
		System.err.println("Test");
		courseRepo.DeleteById(10001L);
		assertNull(courseRepo.findById(10001L));
	}

	@Test
	@DirtiesContext
	void save_Test() {
		
		Course course = courseRepo.findById(10001L);
		course.setName("Node js");
		courseRepo.save(course);
		assertEquals("Node js",courseRepo.findById(10001L).getName() );
	}
	

}
