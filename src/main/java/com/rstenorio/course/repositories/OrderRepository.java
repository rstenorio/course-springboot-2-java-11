package com.rstenorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rstenorio.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
