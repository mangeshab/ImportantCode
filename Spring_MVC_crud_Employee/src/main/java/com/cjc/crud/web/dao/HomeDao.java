package com.cjc.crud.web.dao;

import java.util.List;

import com.cjc.crud.web.model.Employee;

public interface HomeDao {
	
	public void saveData(Employee e);

	public int logincheck(String uname, String pass);

	public List displayData();

	public void deleteData(int eid);

	public Employee editData(Employee e);

	public int updateData(Employee e);
}
