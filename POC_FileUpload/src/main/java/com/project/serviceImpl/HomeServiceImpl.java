package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.DocumentUpload;
import com.project.repository.HomeRepository;
import com.project.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
		@Autowired
		HomeRepository hr;

		@Override
		public List<DocumentUpload> savedoc(DocumentUpload d) {
			hr.save(d);
			List<DocumentUpload>list=hr.findAll();
			return list;
		}
		public List<DocumentUpload> getDoc() {
			List<DocumentUpload> l1=hr.findAll();
			return l1;
		}
}
