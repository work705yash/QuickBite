package com.base.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.models.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {

Optional<FoodOrder> findByUser_IdAndStatus(Long userId, String status);

List<FoodOrder> findByUser_IdAndStatusNot(Long userId, String status);

}
