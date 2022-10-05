package com.project.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.DocumentUpload;
import com.project.service.HomeService;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/document")
public class HomeController {
	
		@Autowired
		HomeService hs;
		
		private static final Logger log=null;
		@RequestMapping(value = "/adddoc",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		public List<DocumentUpload> fileupload(@RequestPart(required = true,value="address_proof") MultipartFile files1,
				@RequestPart(required = true,value="photo") MultipartFile files2,
				@RequestPart(required = true,value="signature") MultipartFile files3,
				@RequestPart(required = true,value="thumb") MultipartFile files4,
				@RequestPart("doc") String doc) throws IOException
		{
			System.out.println(doc);
			log.info("Document upload");
			DocumentUpload d=new DocumentUpload();
			d.setAddress_proof(files1.getBytes());
			d.setPhoto(files2.getBytes());
			d.setSignature(files3.getBytes());
			d.setThumb(files4.getBytes());
			
			ObjectMapper om=new ObjectMapper();
			DocumentUpload d1=om.readValue(doc,DocumentUpload.class);
			
			d.setCustomer_id(d1.getCustomer_id());
			System.out.println(d.getCustomer_id());
			
			
			List<DocumentUpload> list=hs.savedoc(d);
			
			return list;
			
		}
		@GetMapping("/files")
		public List<DocumentUpload> getFiles()
		{
			return hs.getDoc();
		}
}
