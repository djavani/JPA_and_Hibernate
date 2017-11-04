package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	// Sessiosn & SessionFactory
	// EntityManager & PersistenceContext
	// Transaction
	
	@Test
	@Transactional
	public void someTest() {
		 repository.someOperationToUndestandPersistenceContext();
		
	}

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 20001L);
		logger.info("Student -> {}", student);
		logger.info("Passport -> {}", student.getPassport());
	}

	
	
	
	

}
