package com.in28Minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.entities.Address;
import com.in28Minutes.jpa.hibernate.demo.entities.Course;
import com.in28Minutes.jpa.hibernate.demo.entities.Passport;
import com.in28Minutes.jpa.hibernate.demo.entities.Review;
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
	
	public Student retieveStudentAndCourse(Long studentId)
	{
		 Student student= em.find(Student.class, studentId);
		 return student;
	}
	
	public void saveStudentAndCourseHardcore()
	{
		Student student = new Student("Pranali");
		Course course = new Course("Finance in 100 steps");
		
		em.persist(student);
		em.persist(course);
		
		student.addCourses(course);
		course.addStudents(student);
		
		//em.persist(student);
		//em.persist(course);
	}
	
	public void saveStudentAndCourse(Student student, Course course)
	{
		
		student.addCourses(course);
		course.addStudents(student); 
		
		em.persist(student);
		em.persist(course);
		

	}
	
	public void saveCourseForStudent(Long studentId, Long courseId)
	{
		Student student = em.find(Student.class, studentId);
		Course course = em.find(Course.class, courseId);
		
		student.addCourses(course);
		//course.addStudents(student); 
		
		em.persist(student);
		//em.persist(course);
		

	}
	
	public void saveStudentEnrollInNewCourse(Long studentId, Long courseId)
	{
		Student student = em.find(Student.class, studentId);
		Course course = em.find(Course.class, courseId);
		
		student.addCourses(course);
		//course.addStudents(student); 
		
		em.persist(student);
		//em.persist(course);
		

	}
	
	public void AddReview(Long studentId, Long courseId,Review reviewObj)
	{
		Student student = em.find(Student.class, studentId);
		Course course = em.find(Course.class, courseId);
		
		Review review= reviewObj;
		review.setCourse(course);
		review.setStudent(student);
		
		//course.addStudents(student); 
		
		em.persist(review);
		//em.persist(course);
		

	}
	
	//for @Embedded address Testing
	public void embedded_studentAddressSave()
	{
		Passport passport= new Passport("R12345");
		em.persist(passport);
		Student student = new Student("Vidya");
		student.setAddress(new Address("cheda","Pense","Dombivli"));
		
		student.setPassport(passport);
		em.persist(student);	
		
		Student student1= em.find(Student.class, 20001L);
		if(student1.getAddress()!=null) {
			
		}
		else
		{
			student1.setAddress(new Address("Manali","Gulaba","Himachal"));
		}
		em.persist(student1);
		
		
		
	}
	
}