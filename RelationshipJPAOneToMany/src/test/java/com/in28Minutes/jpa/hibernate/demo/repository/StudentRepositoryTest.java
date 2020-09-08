package com.in28Minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;
import com.in28Minutes.jpa.hibernate.demo.entities.Course;
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
		Student student = em.find(Student.class,20001L);
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
	
	
//Many to many
	@Test
	@Transactional
	public void retriveCourseFromStudent()
	{
		Student student = studentRepo.retieveStudentAndCourse(20001L);
		logger.info("Student -> {}",student);
		logger.info("Student's course -> {}",student.getCourses());
	}

	@Test
	@Transactional
	public void retriveStudentFromCourse()
	{
		Course course = em.find(Course.class,10001L);
		logger.info("Course -> {}",course);
		logger.info("Students in course -> {}",course.getStudents());
	}
	
	@Test
	void EmbeddedAddress_findById_Test() {
		System.err.println("Test");
		Student student = em.find(Student.class,20001L);
		logger.info("student -> {}", student);
		logger.info("Address -> {}",student.getAddress());
	}
}
