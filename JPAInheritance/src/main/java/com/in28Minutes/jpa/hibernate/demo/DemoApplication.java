package com.in28Minutes.jpa.hibernate.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28Minutes.jpa.hibernate.demo.entities.FullTimeEmployee;
import com.in28Minutes.jpa.hibernate.demo.entities.PartTimeEmployee;
import com.in28Minutes.jpa.hibernate.demo.repository.EmployeeRepository;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		employeeRepository.InsertEmpolyee(new PartTimeEmployee("Jil",new BigDecimal(50)));
		employeeRepository.InsertEmpolyee(new FullTimeEmployee("Jack", new BigDecimal(10000)));
		
		logger.info("All full employee -> {}",employeeRepository.findAllFullTimeEmployee());
		logger.info("All full employee -> {}",employeeRepository.findAllPartTimeEmployee());
	
	}

}
