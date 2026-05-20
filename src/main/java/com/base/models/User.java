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
	
	
	
	

}
