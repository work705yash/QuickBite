package com.base.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String location;
	private double rating;
	private boolean IsOpen;
	private LocalDateTime  createdAt;
	private LocalDateTime updatedAt;
	
	//relationship
	@ManyToOne
	@JoinColumn(name="owner_id")
	private User owner;
	
	@OneToMany(mappedBy ="restaurant")
	private List<FoodItem> FoodItem;
	
	
	
	
	
	
}
