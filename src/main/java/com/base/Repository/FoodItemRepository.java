package com.base.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.models.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
	List<FoodItem> findByRestaurant_Id(Long restaurantId);
	
}
