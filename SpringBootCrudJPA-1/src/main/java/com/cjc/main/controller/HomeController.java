package com.cjc.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@Controller
	public class HomeController 
	{

		@Autowired
		HomeService hs;
		
		@RequestMapping("/")
		public String prelogin()
		{
			return "login";
		}
		
		@RequestMapping("/registration")
		public String preregister()
		{
			return "registration";
		}
		
		@RequestMapping("/reg")
		public String regData(@ModelAttribute Student s)
		{
			
			hs.saveData(s);
			System.out.println("Save SuccessFully");
			return "login";
		}
		
		@RequestMapping("/login")
		public String loginData(@RequestParam("uname")String un,@RequestParam("password") String ps,Model m)
		{
			Student id=hs.logincheck(un,ps);
			Iterable<Student> stu=hs.displayData();
			String admin="admin";
			if(un.equalsIgnoreCase(admin)&&ps.equalsIgnoreCase(admin))
			{
				m.addAttribute("data", stu);
			return "success";
			}
			else if(un.equalsIgnoreCase(id.getUname())&&ps.equalsIgnoreCase(id.getPassword()))
			{
				List<Student> l=new ArrayList<Student>();
				l.add(id);
				m.addAttribute("data", l);
				return "success";
			}
			
			else
			{
				return "login";
			}
			
		}
		@RequestMapping("/delete")
		public String deleteData(@RequestParam("uid") int uid,Model m)
		{
			hs.deleteRecord(uid);
			Iterable<Student> stu=hs.displayData();
			m.addAttribute("data", stu);
			return "success";
		}
		
		@RequestMapping("/edit")
		public String editData(@RequestParam("uid") int uid,Model m)
		{
			Student s=hs.editData(uid);
			m.addAttribute("data",s);
			return "edit";
		}
		
		@RequestMapping("/update")
		public String updateData(@ModelAttribute Student s,Model m)
		{
			hs.saveData(s);
			Iterable<Student> stu=hs.displayData();
			m.addAttribute("data", stu);
			return "success";
		}
			
}
