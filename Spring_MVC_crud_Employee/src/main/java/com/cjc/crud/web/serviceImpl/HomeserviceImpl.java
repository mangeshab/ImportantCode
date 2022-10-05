package com.cjc.crud.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.crud.web.dao.HomeDao;
import com.cjc.crud.web.model.Employee;
import com.cjc.crud.web.service.Homeservice;

@Service
public class HomeserviceImpl implements Homeservice{
		
	@Autowired
	HomeDao hd;
	
	@Override
	public void saveData(Employee e) 
	{
		hd.saveData(e);
		
	}

	@Override
	public int logincheck(String uname, String pass) {
		
		return hd.logincheck(uname,pass);
	}

	@Override
	public List displayData() {
		
		return hd.displayData();
	}

	@Override
	public void deleteData(int eid) {
		
		hd.deleteData(eid);
		
	}

	@Override
	public Employee editData(Employee e) {
		
		return hd.editData(e);
	}

	@Override
	public int updateData(Employee e) {
		
		return hd.updateData(e);
	}
	
}
