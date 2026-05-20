package com.base.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OderItem {
	@Id
	@GeneratedValue
	private long id;
	private Integer quantity;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private FoodOrder order;
	
	@ManyToOne
	@JoinColumn(name="food_item")
	private FoodItem FoodItem;
	
	

}
