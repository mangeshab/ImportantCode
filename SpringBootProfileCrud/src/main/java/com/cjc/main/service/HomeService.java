package com.cjc.main.service;

import com.cjc.main.model.Student;

public interface HomeService
{
public void saveData(Student s);

public Student logincheck(String un, String ps);

public Iterable<Student> displayData();

public void deleteRecord(int uid);

public Student editData(int uid);

}

