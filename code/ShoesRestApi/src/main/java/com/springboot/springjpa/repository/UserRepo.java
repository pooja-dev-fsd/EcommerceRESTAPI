package com.springboot.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.springboot.springjpa.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	//@Query("SELECT u FROM  User u WHERE u.name = :name")
	//public List<User> findByName(@Param("name") String name);
}
