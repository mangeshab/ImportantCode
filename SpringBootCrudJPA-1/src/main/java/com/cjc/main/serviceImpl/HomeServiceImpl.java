package com.cjc.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService
{

	@Autowired
	HomeRepository hr;
	
	@Override
	public void saveData(Student s) 
	{
		String mobileno=s.getMobileno();
		Student stu=hr.findByMobileno(mobileno);
	if(stu==null)
		{
		hr.save(s);	
		}
		else{
			System.out.println("Mobile no Already Exists");
		}
	}

	@Override
	public Student logincheck(String un, String ps) {
		
		return hr.findAllByUnameAndPassword(un,ps);
	}

	@Override
	public Iterable<Student> displayData() {
		
		return hr.findAll();
	}

	@Override
	public void deleteRecord(int uid) {
		hr.deleteById(uid);
		
	}

	@Override
	public Student editData(int uid) {
		
		return hr.findAllByUid(uid);
	}

	

}

