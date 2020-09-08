package com.in28Minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;

@SpringBootTest(classes=DemoApplication.class)
class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	
	@Autowired
	EntityManager em;
	

}
