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
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isIsOpen() {
		return IsOpen;
	}

	public void setIsOpen(boolean isOpen) {
		IsOpen = isOpen;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<FoodItem> getFoodItem() {
		return FoodItem;
	}

	public void setFoodItem(List<FoodItem> foodItem) {
		FoodItem = foodItem;
	}

	
	
	
	
	
	
}
