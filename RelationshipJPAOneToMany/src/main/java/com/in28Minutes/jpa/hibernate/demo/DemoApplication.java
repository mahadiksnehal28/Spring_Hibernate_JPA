package com.in28Minutes.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28Minutes.jpa.hibernate.demo.entities.Course;
import com.in28Minutes.jpa.hibernate.demo.entities.Review;
import com.in28Minutes.jpa.hibernate.demo.entities.Student;
import com.in28Minutes.jpa.hibernate.demo.entities.reviewRating;
import com.in28Minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28Minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		courseRepository.addHardCodeReviewForCourse();
		
		
		//List<Review> reviews = new ArrayList<Review>();
		//reviews.add(new Review(reviewRating.TWO,"Worst"));
		//reviews.add(new Review(reviewRating.FIVE,"Excelent"));
		//courseRepository.addReviewForCourse(10001L,reviews);
		
		
		//Many to Many
		//studentRepository.saveStudentAndCourseHardcore();
		
//		Student student = new Student("Pranali");
//		Course course = new Course("Finance in 100 steps");
//		studentRepository.saveStudentAndCourse(student, course);
		
		
		//studentRepository.saveCourseForStudent(20003L,10002L);
	//	studentRepository.saveStudentEnrollInNewCourse(20002L, 10002L);
		
		//Review reviewObj = new Review(reviewRating.THREE,"Best course");
		//studentRepository.AddReview(20002L, 10002L, reviewObj);
		//courseRepository.DeleteById(10004L);
		
		//studentSave
		//studentRepository.embedded_studentAddressSave();
	}

}
