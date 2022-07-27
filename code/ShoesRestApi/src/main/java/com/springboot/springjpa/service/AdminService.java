package com.springboot.springjpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.springjpa.model.Admin;
import com.springboot.springjpa.repository.AdminRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo repo;
	
	public Admin addUser(Admin user) {
		return repo.save(user);
	}
	public List<Admin> getAllUsers(){
		
		return repo.findAll();
	}
	public Admin getUserById(int id) {
		
		if(repo.findById(id).isPresent())
			return repo.findById(id).get();
		else
			return null;
	}
	public Admin updateAdmin(Admin user, int id) {
		if(repo.findById(id).isPresent())
		{
			Admin old= repo.findById(id).get();
			old.setName(user.getName());
			old.setEmail(user.getEmail());
			old.setPassword(user.getPassword());
			old.setAddress(user.getAddress());
			old.setPhoneno(user.getPhoneno());		
			return repo.save(old);
		}
		else
			return null;
	}
	public boolean deleteUser(int id) {
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}
	public Admin validate(Admin user,Admin pass)
	{
		Admin admin= null;
		if((repo.getById(1).getName()).equals(user.getName()))
			return	repo.save(admin);
		else 
			return null;	
	
	}
}

