package com.rstenorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rstenorio.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
