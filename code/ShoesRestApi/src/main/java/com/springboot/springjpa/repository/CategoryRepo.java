package com.springboot.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springjpa.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
