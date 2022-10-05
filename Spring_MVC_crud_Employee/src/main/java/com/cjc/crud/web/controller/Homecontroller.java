package com.cjc.crud.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.crud.web.model.Employee;
import com.cjc.crud.web.service.Homeservice;


@Controller
public class Homecontroller
{
	@Autowired
	Homeservice hs;
	
	@RequestMapping("/")
	public String prelogin()
	{
		
		return "login";
	}
	
	@RequestMapping("/reg")
	public String registerData(@ModelAttribute Employee e)
	{
		
		hs.saveData(e); 
		return "login";
	}
	
	@RequestMapping("/registration")
	public String preRegister()
	{
		
		return "registration";
	}
	
	@RequestMapping("/login")
	public String update(@RequestParam("un") String uname,@RequestParam("ps") String pass,Model m)
	{
		int id=hs.logincheck(uname,pass);
		
		List al=hs.displayData();
		
		if(id>0)
		{
			m.addAttribute("data",al);
			return "success";
		}
		else
		{
			return "login";
		}
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam("eid") int eid,Model m)
	{
		hs.deleteData(eid);
		
		List al=hs.displayData();
		
		m.addAttribute("data",al);
		
		return "success";
	}
	@RequestMapping("/edit")
	public String editPage(@ModelAttribute Employee e,Model m)
	{
		Employee emp=hs.editData(e);
		
		m.addAttribute("data",emp);
		return "edit";
	}
	@RequestMapping("/update")
	public String update(@ModelAttribute Employee e,Model m)
	{
		int id=hs.updateData(e);
		
		if(id>0)
		{
			List al=hs.displayData();
			
			m.addAttribute("data",al);
			
			return "success";
		}
		else
		{
			return "login";
		}
	}
}
