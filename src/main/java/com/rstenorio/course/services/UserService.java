package com.rstenorio.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rstenorio.course.entities.User;
import com.rstenorio.course.repositories.UserRepository;

@Service
public class UserService {
	
	//Autowired = Injecao de dependencia feita automaticamente pelo Spring
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long Id) {
		Optional<User> obj = repository.findById(Id);
		return obj.get();
	}
	
}
