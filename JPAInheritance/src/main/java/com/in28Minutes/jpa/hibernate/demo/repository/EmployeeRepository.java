package com.in28Minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.entities.Employee;
import com.in28Minutes.jpa.hibernate.demo.entities.FullTimeEmployee;
import com.in28Minutes.jpa.hibernate.demo.entities.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {
	
	@Autowired
	EntityManager em;
	
	Logger logger= org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	public void InsertEmpolyee(Employee employee)
	{
		em.persist(employee);
		//return em.find(Course.class, Id);
	}
	
	public List<Employee> findAll()
	{
		return em.createQuery("Select e from Employee e", Employee.class).getResultList();
	}

	public List<PartTimeEmployee> findAllPartTimeEmployee()
	{
		return em.createQuery("Select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	public List<FullTimeEmployee> findAllFullTimeEmployee()
	{
		return em.createQuery("Select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
	
}
