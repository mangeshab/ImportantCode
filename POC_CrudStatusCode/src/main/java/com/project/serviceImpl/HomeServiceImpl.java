package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Student;
import com.project.repository.HomeRepository;
import com.project.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{

	@Autowired
	HomeRepository hr;
	
	
	@Override
	public void saveData(Student s) {
		
		hr.save(s);
	}


	@Override
	public List<Student> getAllData() {
		
		return hr.findAll();
	}


	@Override
	public void deleteData(int id) {
			hr.deleteById(id);
		
	}


	@Override
	public Student update(Student s) {
		// TODO Auto-generated method stub
		return hr.save(s);
	}

}
