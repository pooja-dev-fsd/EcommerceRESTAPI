package com.springboot.springjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springjpa.model.Category;
import com.springboot.springjpa.repository.CategoryRepo;


@Service
public class CategoryService {

	@Autowired
	private CategoryRepo repo;
	
	public Category addCategory(Category category) {
		return repo.save(category);
	}
	public List<Category> getAllCategory(){
		
		return repo.findAll();
	}
	public Category getCategoryById(int id) {
		
		if(repo.findById(id).isPresent())
			return repo.findById(id).get();
		else
			return null;
	}
	public Category updateCategory(Category category, int id) {
		if(repo.findById(id).isPresent())
		{
			Category old= repo.findById(id).get();
			old.setCategory_name(category.getCategory_name());
			old.setCategory_type(category.getCategory_type());
		
			
			
			return repo.save(old);
		}
		else
			return null;
	}
	public boolean deleteCategory(int id) {
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	
}
