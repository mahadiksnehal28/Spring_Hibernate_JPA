package com.in28Minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.entities.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long Id)
	{
		return em.find(Course.class, Id);
	}

	public void DeleteById(Long Id)
	{
		Course course =  em.find(Course.class, Id);
		em.remove(course);
		//System.err.println("Deleted Successfully");
	}
	public Course save(Course course)
	{
		System.err.println(course.getId());
		if(course.getId() == null)
		{
			em.persist(course);
		}
		else 
		{
			em.merge(course);
		}
		return course;
	}
	
	public void DetailsAboutEntityManager()
	{
//		//Eg of detach -detach entity manager and it will no longer update
//		Course course1= new Course("JPA");
//		em.persist(course1);
//		
//		Course course2= new Course("JPA-1");
//		em.persist(course2);
//		em.flush();
//		
//		//Detach entity manager and it will no longer update
//		
//		course1.setName("Angular");		
//		course2.setName("Angular-2");
//		em.detach(course2);
		
		
//		Course course1= new Course("JPA");
//		em.persist(course1);
//		
//		Course course2= new Course("JPA-1");
//		//em.persist(course2);
//		em.flush();
//		course1.setName("Angular");		
//		course2.setName("Angular-2");
//		//it woll clear em 
//		em.clear();
		
		
//		//Refresh will re
//		Course course1= new Course("JPA");
//		em.persist(course1);
//		
//		Course course2= new Course("JPA-1");
//		//em.persist(course2);
//		em.flush();
//		
//				
//		course1.setName("Angular");
//		
//		course2.setName("Angular-2");
//		//Refresh willrefresh couse2 and it will not saved to DB
//		em.refresh(course2);
		
		
		//To check updated and created timestamp
		Course course1=em.find(Course.class, 10001L);
		course1.setName("Node");
		this.save(course1);
		
		//Native query used for mass update or JPA is not present
//		Query query = em.createNativeQuery("update course set  name= :name",Course.class);
//		query.setParameter("name", "Python");
//		int noofRowsupdated = query.executeUpdate();
		
	}
	
	
}
