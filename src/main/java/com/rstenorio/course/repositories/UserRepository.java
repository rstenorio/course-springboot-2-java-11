package com.rstenorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rstenorio.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
