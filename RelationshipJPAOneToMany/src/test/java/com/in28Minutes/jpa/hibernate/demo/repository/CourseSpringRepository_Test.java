package com.in28Minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;
import com.in28Minutes.jpa.hibernate.demo.entities.Course;


//@SpringBootTest(classes=DemoApplication.class)
class CourseSpringRepository_Test {
	
	@Autowired
	CourseSpringRepository coursespringRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	
	
	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Test
	void findById() {
		Optional<Course> course = coursespringRepo.findById(10001L);
		assertTrue(course.isPresent());
		logger.info("Course {}",course);
	}
	
	@Test
	void findById_not_present() {
		Optional<Course> course = coursespringRepo.findById(20001L);
		assertFalse(course.isPresent());
		logger.info("Course {}",course);
	}

	@Test
	void CrudRepoMethod_Test() {
		//Create new course
		Course course=new Course("Microservices in 50 steps");
		coursespringRepo.save(course);
		
		//update same course
		course.setName("Microservices in 50 steps- Updated");
		coursespringRepo.save(course);
		
		logger.info("find alll {} ",coursespringRepo.findAll());
		logger.info("Count {} ", coursespringRepo.count());
		logger.info("existsById {}",coursespringRepo.existsById(20001L));
		List<Long> ids= new ArrayList<Long>();
		ids.add(1L);
		ids.add(10002L);
		logger.info("findAllById {} ids",coursespringRepo.findAllById(ids));

	}
	
	@Test
	void Paggination_Test()
	{
		PageRequest pageRequest= PageRequest.of(0, 2);
		Page<Course> firsepage = coursespringRepo.findAll(pageRequest);
		logger.info("first page {} ",firsepage.getContent());
		
		Pageable secondPageable = firsepage.nextPageable();
		Page<Course> secondPage = coursespringRepo.findAll(secondPageable);
		logger.info("second page {} ",secondPage.getContent());
	}
	
	@Test
	void customQuries_Test()
	{
		logger.info("courses by name {}",coursespringRepo.findByName("jpa in 50 steps"));
		//logger.info("courses by name {}",coursespringRepo.findByStudentId(20002L));
		
	}
	
	@Test
	void softDelete_Test()
	{
		logger.info("Deleted course {}",coursespringRepo.findById(10004L));
		coursespringRepo.deleteById(10004L);
		
		logger.info("Deleted course {}",coursespringRepo.findById(10004L));
	}
	
	@Test
	void PreDelete_Test()
	{
		logger.info("Deleted course {}",coursespringRepo.findById(10004L));
		courseRepo.DeleteById(10004L);
		
	}
}
