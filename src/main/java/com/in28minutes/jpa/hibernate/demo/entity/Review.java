package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String rating;
	
	private String description;	
	
	protected Review() {
		
	}

	public Review(String rating,String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}	
	

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating, description);
	}
}
