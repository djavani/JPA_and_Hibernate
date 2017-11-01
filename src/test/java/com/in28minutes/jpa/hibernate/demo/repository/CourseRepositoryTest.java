package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic () {
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());	
		
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic () {
		repository.deletedById(10002L);
		assertNull(repository.findById(10002L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		
		Course course = repository.findById(10001L);
		assertEquals("JPA in 50 Steps", course.getName());
		
		course.setName("JPA in 50 Steps - UPDATED");	
				
		repository.save(course);
		
		Course course1 = repository.findById(10001L);
		assertEquals("JPA in 50 Steps - UPDATED", course1.getName());
	}

}
