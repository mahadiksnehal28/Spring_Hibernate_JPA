package com.in28Minutes.jpa.hibernate.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes=DemoApplication.class)
class DemoApplicationTests {

	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Test
	void findById_Test() {
		System.err.println("Test");
	
	}


}
