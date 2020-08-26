package com.in28Minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;
import com.in28Minutes.jpa.hibernate.demo.entities.Course;

@SpringBootTest(classes=DemoApplication.class)
class JPQL_Test {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	

	@Test
	public void findAll_Test()
	{
		//Create query exqample
//		Query Query = em.createQuery("Select c from Course c");
//		List resultSet = Query.getResultList();
//		logger.info("Select c from course -> {}",resultSet);
		
		//NameQuery Example
		Query Query = em.createNamedQuery("get_all_Course");
		List resultSet = Query.getResultList();
		logger.info("Select c from course -> {}",resultSet);
	}
	
	@Test
	public void findById_Typed()
	{
		//Create query exqample
//		TypedQuery<Course> query = em.createQuery("Select c from Course c",Course.class);
//		List resultSet = query.getResultList();
//		logger.info("Select c from course -> {}",resultSet);
		
		
		//NameQuery Example
		TypedQuery<Course> query = em.createNamedQuery("get_all_Course",Course.class);
		List resultSet = query.getResultList();
		logger.info("Select c from course -> {}",resultSet);
		
	}
	
	@Test
	public void FindByWhere_Typed()
	{
		//Create Query Examples
//		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%ng%'",Course.class);
//		List resultSet = query.getResultList();
//		logger.info("Select c from Course c where name like 'JP% -> {}",resultSet);
		
		//NamedQuery Query examples
		TypedQuery<Course> query = em.createNamedQuery("get_all_with_name_JPA",Course.class);
		List resultSet = query.getResultList();
		logger.info("Select c from Course c where name like 'JPA% -> {}",resultSet);
		
	}
	
	@Test
	public void FindBy_Native()
	{
		
		
		Query query = em.createNativeQuery("select * from course",Course.class);
		List resultSet = query.getResultList();
		logger.info("Select using Native Query-> {}",resultSet);
		
	}
	
	@Test
	public void FindByWhere_Native()
	{
		
		
		Query query = em.createNativeQuery("select * from course where id = :id",Course.class);
		//query.setParameter(1, 10001L);
		query.setParameter("id", 10001L);
		List resultSet = query.getResultList();
		logger.info("Select using Native Query-> {}",resultSet);
		
	}
	
	@Test
	@Transactional
	public void update_Native()
	{
		
		
		Query query = em.createNativeQuery("update course set  name= :name",Course.class);
		query.setParameter("name", "Python");
		//query.setParameter("id", 10001L);
		int noofRowsupdated = query.executeUpdate();
		logger.info("noofRowsupdated-> {}",noofRowsupdated);
		
	}

}
