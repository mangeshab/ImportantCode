package com.project.service;

import java.util.List;

import com.project.model.DocumentUpload;

public interface HomeService {

	List<DocumentUpload> savedoc(DocumentUpload d);
	public List<DocumentUpload> getDoc();
}
