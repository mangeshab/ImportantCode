package com.project.service;

import java.util.List;

import com.project.model.Product;

public interface HomeService {

	public void postData(Product p);

	public List<Product> getAllData();

	public void deleteData(int id);

	public Product updateData(Product p);

	public Product findByName(String name);

	

	

}
