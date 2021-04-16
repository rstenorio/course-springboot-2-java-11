package com.rstenorio.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rstenorio.course.entities.Order;
import com.rstenorio.course.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository Repository;
	
	public List<Order> findAll(){
		return Repository.findAll();
	}
	
	public Order findById(Long Id) {
		Optional<Order> obj =  Repository.findById(Id);
		return obj.get();
	}
	
}
