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

import com.springboot.springjpa.model.Category;
import com.springboot.springjpa.service.CategoryService;

@RestController
@RequestMapping("shoesapi/admin/category")
public class CategoryController {

	@Autowired
	private CategoryService service;
	@PostMapping("/")
	public ResponseEntity<Object> addCategory(@RequestBody Category category){
		
		Category data= service.addCategory(category);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while add category", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/")
	public List<Category> getAllCategory(){
		return service.getAllCategory();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable int id){

		if(service.getCategoryById(id)!=null)
			return new ResponseEntity<Object>(service.getCategoryById(id),HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Category is not available with given id",
					HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category,@PathVariable int id){
		Category data= service.updateCategory(category, id);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Category is not available with for update",
					HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		if(service.deleteCategory(id))
			return new ResponseEntity<Object>("Category deleted ", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Category Found ", HttpStatus.NOT_FOUND);
	}
}


