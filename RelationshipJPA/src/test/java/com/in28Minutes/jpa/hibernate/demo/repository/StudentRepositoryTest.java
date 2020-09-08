package com.in28Minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;
import com.in28Minutes.jpa.hibernate.demo.entities.Passport;
import com.in28Minutes.jpa.hibernate.demo.entities.Student;

@SpringBootTest(classes=DemoApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	EntityManager em;
	
	
	@Test
	@Transactional
	void findById_Test() {
		System.err.println("Test");
		Student student = em.find(Student.class,20002L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}",student.getPassport());
	}

	@Test
	@Transactional
	void retivePassportFromStudent_Test() {
		System.err.println("Test");
		Student student = em.find(Student.class,20002L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}",student.getPassport());
	}
	
	@Test
	@Transactional
	void retiveStudentFromPassport_Test() {
		System.err.println("Test");
		Passport passport = em.find(Passport.class,30002L);
		logger.info("passport -> {}", passport);
		logger.info("Student -> {}",passport.getStudent());
	}


}
