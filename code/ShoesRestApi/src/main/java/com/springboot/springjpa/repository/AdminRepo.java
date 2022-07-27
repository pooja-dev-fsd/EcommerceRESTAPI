package com.springboot.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springjpa.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
