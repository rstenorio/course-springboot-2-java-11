package com.rstenorio.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rstenorio.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
