package com.springboot.springjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springjpa.model.Admin;
import com.springboot.springjpa.service.AdminService;
import com.springboot.springjpa.repository.AdminRepo;

@RestController
@RequestMapping("shoesapi/admin")

public class AdminController {

	@Autowired
	private AdminService service;
	@Autowired
	private AdminRepo repo;
	@PostMapping("/")
	public ResponseEntity<Object> addUser(@RequestBody Admin user){
		
		Admin data= service.addUser(user);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while add user", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/")
	public List<Admin> getAllUsers(){
		
		return service.getAllUsers();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable int id){

		if(service.getUserById(id)!=null)
			return new ResponseEntity<Object>(service.getUserById(id),HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("User is not available with given id",
					HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Object> validate(@RequestBody Admin user,@RequestBody Admin pass)
	{
		//user.setName("admin123@gmail.com");
		Admin data = service.validate(user, pass);
		if(data != null)
			return new ResponseEntity<Object>(data,HttpStatus.OK);
			
		else
			return new ResponseEntity<Object>(user.getName(),
					HttpStatus.OK);
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody Admin user,@PathVariable int id){
		Admin data= service.updateAdmin(user, id);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("User is not available with for update",
					HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		if(service.deleteUser(id))
			return new ResponseEntity<Object>("User deleted ", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No User Found ", HttpStatus.NOT_FOUND);
	}
}

