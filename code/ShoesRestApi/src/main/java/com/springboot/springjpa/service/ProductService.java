package com.springboot.springjpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.springjpa.model.Product;
import com.springboot.springjpa.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public Product addProduct(Product product) {
		return repo.save(product);
	}
	public List<Product> getAllProduct(){
		
		return repo.findAll();
	}
	public Product getProductById(int id) {
		
		if(repo.findById(id).isPresent())
			return repo.findById(id).get();
		else
			return null;
	}
	public Product updateProduct(Product product, int id) {
		if(repo.findById(id).isPresent())
		{
			Product old= repo.findById(id).get();
			old.setProduct_name(product.getProduct_name());
			old.setProduct_desc(product.getProduct_desc());
			old.setProduct_price(product.getProduct_price());
			
			
			return repo.save(old);
		}
		else
			return null;
	}
	public boolean deleteProduct(int id) {
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
}
