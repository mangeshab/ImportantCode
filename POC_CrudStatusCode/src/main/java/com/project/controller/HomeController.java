package com.project.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Student;
import com.project.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	HomeService hs;
	
	@PostMapping("/saveData")
	public ResponseEntity<Student> postData(@RequestBody Student s)
	{
		hs.saveData(s);
		return new ResponseEntity<Student>(s,HttpStatus.CREATED);
	}
	@GetMapping("/getAllData")
	public ResponseEntity<List<Student>> getData()
	{
		List<Student> lst=hs.getAllData();
		return new ResponseEntity<List<Student>>(lst,HttpStatus.OK);
	}
	@DeleteMapping("/deleteData/{id}")
	public ResponseEntity<Integer> deleteData(@PathVariable int id)
	{
		hs.deleteData(id);
		return new ResponseEntity<Integer>(id,HttpStatus.NO_CONTENT);
	}
	@PutMapping("/updateData")
	public ResponseEntity<Student> update(@RequestBody Student s)
	{
		Student s1=hs.update(s);
		return new ResponseEntity<Student>(s1,HttpStatus.OK);
	}
}
