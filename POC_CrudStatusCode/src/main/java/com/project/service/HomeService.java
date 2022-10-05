package com.project.service;

import java.util.List;

import com.project.model.Student;

public interface HomeService {

	void saveData(Student s);

	List<Student> getAllData();

	void deleteData(int id);

	Student update(Student s);

}
