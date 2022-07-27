package com.springboot.springjpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springjpa.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}

