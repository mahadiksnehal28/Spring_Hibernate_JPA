package com.in28Minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.entities.Passport;
import com.in28Minutes.jpa.hibernate.demo.entities.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long Id)
	{
		return em.find(Student.class, Id);
	}

	public void DeleteById(Long Id)
	{
		Student student =  em.find(Student.class, Id);
		em.remove(student);
		//System.err.println("Deleted Successfully");
	}
	public void studentSave()
	{
		Passport passport= new Passport("R12345");
		em.persist(passport);
		Student student = new Student("Vidya");
		student.setPassport(passport);
		em.persist(student);				
		
	}
	
}