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

import com.springboot.springjpa.model.Product;
import com.springboot.springjpa.service.ProductService;

@RestController
@RequestMapping("shoesapi/admin/product")
public class ProductController {

	@Autowired
	private ProductService service;
	@PostMapping("/")
	public ResponseEntity<Object> addProduct(@RequestBody Product product){
		
		Product data= service.addProduct(product);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while add product", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable int id){

		if(service.getProductById(id)!=null)
			return new ResponseEntity<Object>(service.getProductById(id),HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Product is not available with given id",
					HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Product product,@PathVariable int id){
		Product data= service.updateProduct(product, id);
		if(data!=null)
			return new ResponseEntity<Object>(data,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Product is not available with for update",
					HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id){
		if(service.deleteProduct(id))
			return new ResponseEntity<Object>("Product deleted ", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Product Found ", HttpStatus.NOT_FOUND);
	}
}


