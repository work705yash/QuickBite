package com.base.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.models.OderItem;

public interface OderItemRepository extends JpaRepository<OderItem, Long> {
	List<OderItem> findByOrder_Id(Long orderId);
}
