package com.base.models;

import java.time.LocalDateTime;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String email;
	private String password;
	private String role;
	private String status;
	private String phone;
	private String address;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	//relationships
	@OneToMany(mappedBy = "owner")
	private List<Restaurant> restaurants;
	
	
	@OneToMany(mappedBy="user")
	private List<FoodOrder> orders;
	
	
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public List<Restaurant> getRestaurants() {
		return restaurants;
	}


	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}


	public List<FoodOrder> getOrders() {
		return orders;
	}


	public void setOrders(List<FoodOrder> orders) {
		this.orders = orders;
	}


	
	
	
	

}
