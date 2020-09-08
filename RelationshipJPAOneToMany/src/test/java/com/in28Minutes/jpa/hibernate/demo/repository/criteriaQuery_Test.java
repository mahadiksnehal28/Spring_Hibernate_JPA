package com.in28Minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;
import com.in28Minutes.jpa.hibernate.demo.entities.Course;
import com.in28Minutes.jpa.hibernate.demo.entities.Student;


//@SpringBootTest(classes=DemoApplication.class)
class criteriaQuery_Test {

	
	@Autowired
	EntityManager em;
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	//Criteria queries
	
	@Test
	void criteriaQuery_test() {
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Course> cq = cb.createQuery(Course.class);
	Root<Course> courseRoot = cq.from(Course.class);
	TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
	
	List<Course> list = query.getResultList();
	logger.info("Course -> {}",list);
	}

	
	@Test
	void criteriaQuery_find_like_100steps_test() {
		
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Course> cq = cb.createQuery(Course.class);
	Root<Course> courseRoot = cq.from(Course.class);
	Predicate like50steps = cb.like(courseRoot.get("name"), "%50 step%");
	
	cq.where(like50steps);
	TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
	
	List<Course> list = query.getResultList();
	logger.info("Course -> {}",list);
	}
	
	@Test
	void criteriaQuery_find_courses_without_Student_test() {
		
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Course> cq = cb.createQuery(Course.class);
	Root<Course> courseRoot = cq.from(Course.class);
	Predicate courseWithoutStudent = cb.isEmpty(courseRoot.get("students"));
	
	cq.where(courseWithoutStudent);
	TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
	
	List<Course> list = query.getResultList();
	logger.info("courses_without_Student -> {}",list);
	}
	
	
	@Test
	void criteriaQuery_join_test() {
		//select c from Course c join c.students s
	CriteriaBuilder cb = em.getCriteriaBuilder();
	CriteriaQuery<Course> cq = cb.createQuery(Course.class);
	Root<Course> courseRoot = cq.from(Course.class);
	courseRoot.join("students");
	Predicate likeCourse = cb.like(courseRoot.get("name"), "%jpa%");
	
	cq.where(likeCourse);
	Query query = em.createQuery(cq.select(courseRoot));
	
	List list = query.getResultList();	
	logger.info("courses_without_Student -> {}",list);
	}
		
}
