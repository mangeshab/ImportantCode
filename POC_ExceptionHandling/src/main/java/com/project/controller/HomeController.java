package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.exception.DataNotFoundException;
import com.project.exception.ProductNotFoundException;
import com.project.model.Product;
import com.project.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	HomeService hs;
	
	@PostMapping("/postData")
	public String postData(@RequestBody Product p)
	{
		hs.postData(p);
		return "Data Saved Successfully";
	}
	@GetMapping("/getAllData")
	public List<Product> getAllData()
	{
		List<Product>list=null;
		if(list!=null)
		{
		 list=hs.getAllData();
		return list;
		}
		else {
			throw new DataNotFoundException("Product data not available");
		}
	}
	
	@DeleteMapping("/deleteData/{id}")
	public String deleteData(@PathVariable("id") int id)
	{
		hs.deleteData(id);
		return "Data Deleted";
	}
	
	@PutMapping("/update")
	public String updateData(@RequestBody Product p)
	{
		hs.updateData(p);
		return "Data Successfully updated";
	}
	
	
	@GetMapping("/productName/{name}")
	public ResponseEntity<Product> findByName(@PathVariable String name)
	{
		//int a=10/0;
		/*
		 * Product pd=null; try {
		 */
		//pd=
		return new ResponseEntity<Product>(hs.findByName(name),HttpStatus.OK);
	/*	System.out.println(pd.getName());
		}
		catch(Exception e){
			throw new ProductNotFoundException("Product Not Available");
		}
		return pd;*/
	}
	//Controller level Exception Handling
	
	/*
	 * @ExceptionHandler(ProductNotFoundException.class) public String
	 * ProductNotFound(ProductNotFoundException e) { return e.getMessage();
	 * 
	 * }
	 * 
	 * @ExceptionHandler(ArithmeticException.class) public String
	 * Artithmeticexception(ArithmeticException e) { return e.getMessage(); }
	 */
}
