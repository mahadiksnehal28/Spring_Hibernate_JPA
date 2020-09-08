package com.in28Minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.in28Minutes.jpa.hibernate.demo.DemoApplication;
import com.in28Minutes.jpa.hibernate.demo.entities.Course;
import com.in28Minutes.jpa.hibernate.demo.entities.Review;
import com.in28Minutes.jpa.hibernate.demo.entities.Student;

@SpringBootTest(classes=DemoApplication.class)
class CourseDemoTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	EntityManager em;
	
//	
//	@Test
//	void findById_Test() {
//		System.err.println("Test");
//		Course course = courseRepo.findById(10001L);
//		assertEquals("jpa in 50 steps",course.getName() );
//	}
//
//
//	@Test
//	@DirtiesContext
//	void DeleteById_Test() {
//		
//		System.err.println("Test");
//		courseRepo.DeleteById(10001L);
//		assertNull(courseRepo.findById(10001L));
//	}
//
//	@Test
//	@DirtiesContext
//	void save_Test() {
//		
//		Course course = courseRepo.findById(10001L);
//		course.setName("Node js");
//		courseRepo.save(course);
//		assertEquals("Node js",courseRepo.findById(10001L).getName() );
//	}
//	

	
	@Test
	@Transactional
	void retrieveReviewsForCourse()
	{
		Course course= em.find(Course.class, 10001L);
		logger.info("Course -> {}",course);
		logger.info("Reviews for course 10001 -> {}",course.getReviews());
	}
	
	@Test
	@Transactional
	void retrieveCourseForReviews()
	{
		Review review= em.find(Review.class, 40002L);
		
		logger.info("Course -> {}",review);
		logger.info("course for review -> {}",review.getCourse());
	}
	
	@Test
	public void jpql_courses_without_students()
	{
		//Create Query Examples
//		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%ng%'",Course.class);
//		List resultSet = query.getResultList();
//		logger.info("Select c from Course c where name like 'JP% -> {}",resultSet);
		
		//NamedQuery Query examples
		TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty",Course.class);
		List resultSet = query.getResultList();
		logger.info("courses does not contain student -> {}",resultSet);
		
	}
	
	@Test
	public void jpql_courses_atleast_2_students()
	{
		//Create Query Examples
//		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%ng%'",Course.class);
//		List resultSet = query.getResultList();
//		logger.info("Select c from Course c where name like 'JP% -> {}",resultSet);
		
		//NamedQuery Query examples
		TypedQuery<Course> query = em.createQuery("select c from Course c where size(c.students)>=2",Course.class);
		List resultSet = query.getResultList();
		logger.info("courses does not contain student -> {}",resultSet);
		
	}
	
	@Test
	public void jpql_courses_orderBy_noOfstudents_students()
	{
		//Create Query Examples
//		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%ng%'",Course.class);
//		List resultSet = query.getResultList();
//		logger.info("Select c from Course c where name like 'JP% -> {}",resultSet);
		
		//NamedQuery Query examples
		TypedQuery<Course> query = em.createQuery("select c from Course c order by size(c.students) desc",Course.class);
		List resultSet = query.getResultList();
		logger.info("courses does not contain student -> {}",resultSet);
		
	}
	
	@Test
	public void jpql_student_with_passport_number_in_certain_pattern()
	{
		//Create Query Examples
//		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%ng%'",Course.class);
//		List resultSet = query.getResultList();
//		logger.info("Select c from Course c where name like 'JP% -> {}",resultSet);
		
		//NamedQuery Query examples
		TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%678%'",Student.class);
		List resultSet = query.getResultList();
		logger.info("courses does not contain student -> {}",resultSet);
		
	}
	
	@Test
	public void jpql_Join()
	{

		Query query = em.createQuery("select c, s, p from Course c join c.students s join s.passport p where p.number like '%678%'");
		List<Object[]> resultSet = query.getResultList();
		logger.info("courses does not contain student -> {}",resultSet.size());
		for(Object[] result: resultSet)
		{
			logger.info("course {} student{} pasport {}",result[0],result[1],result[2]);
		}
		
		
	}
	
	@Test
	public void jpql_Left_Join()
	{

		Query query = em.createQuery("select c,s from Course c left Join c.students s");
		List<Object[]> resultSet = query.getResultList();
		logger.info("courses does not contain student -> {}",resultSet.size());
		for(Object[] result: resultSet)
		{
			logger.info("course {} student {}",result[0],result[1]);
		}
		
		
	}
	

	@Test
	public void jpql_Cross_Join()
	{

		Query query = em.createQuery("select c,s from Course c, Student s");
		List<Object[]> resultSet = query.getResultList();
		logger.info("courses does not contain student -> {}",resultSet.size());
		for(Object[] result: resultSet)
		{
			logger.info("course {} student {}",result[0],result[1]);
		}
		
		
	}
	
	@Test
	@Transactional
	public void findAll_Test()
	{
		List<Course> courses= em.createNamedQuery("get_all_Course", Course.class).getResultList();
		for(Course course:courses) {
			logger.info("course -> {} Student -> {}",course,course.getStudents());
		}
	}
	
	@Test
	@Transactional
	public void NPlusOneProblem_findAll_UsingEntityGraph_Test()
	{
		
		EntityGraph<Course> createEntityGraph = em.createEntityGraph(Course.class);
		createEntityGraph.addSubgraph("students");
		List<Course> courses= em.createNamedQuery("get_all_Course", Course.class).
				setHint("javax.persistence.loadgraph", createEntityGraph)
				.getResultList();
		for(Course course:courses) {
			logger.info("course -> {} Student -> {}",course,course.getStudents());
		}
	}
	
	@Test
	@Transactional
	public void NPlusOneProblem_findAll_UsingJoinFetch_Test()
	{
		List<Course> courses= em.createNamedQuery("get_all_Course_JOINFETCH", Course.class).getResultList();
		for(Course course:courses) {
			logger.info("course -> {} Student -> {}",course,course.getStudents());
		}
	}
}
