package com.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.exception.IdNotFoundException;
import com.project.exception.ProductNotFoundException;
import com.project.model.Product;
import com.project.repository.HomeRepository;
import com.project.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
	
	@Autowired
	HomeRepository hr;
	
	
	@Override
	public void postData(Product p) {
		hr.save(p);
		
	}


	@Override
	public List<Product> getAllData() {
	
		return hr.findAll();
	}


	@Override
	public void deleteData(int id) {
		
		try
		{
		hr.deleteById(id);
	
		}
		catch (Exception e) {
			throw new IdNotFoundException("Product with Id"+" "+id+"" +"not present");
		}
	}

	@Override
	public Product updateData(Product p) {
		return hr.save(p);
		
	}


	@Override
	public Product findByName(String name) {
		Product p=null;
		try
		{
		p= hr.findByName(name);
		System.out.println(p.getName());
		}
		catch(Exception e)
		{
			throw new ProductNotFoundException("Product Not Available");
		}
		return p;
	}
	
		//Product p=hr.findByName(name).orElseThrow(()-> new NameNotFoundException("Product of "+name+" was not found"));
	//}
}
