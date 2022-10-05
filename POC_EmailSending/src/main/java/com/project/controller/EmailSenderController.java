package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.EmailSender;
import com.project.service.EmailSenderService;

@RestController
public class EmailSenderController {
	
	@Autowired
	EmailSenderService ess;
	
	@Value("${spring.mail.username}")
	private String fromEmail;
	
	@PostMapping(value = "/sendemail")
	public String EmailSend(@RequestBody EmailSender eml)
	{
		eml.setFromEmail(fromEmail);
		try
		{
			ess.sendEmail(eml);
			return "Email Send ";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Email not Send";
		}
	}
	
	/*
	 * @PostMapping(value="/sendmailwithattach") public String
	 * sendEmailAttachment(@RequestBody EmailSender eml) {
	 * eml.setFromEmail(fromEmail); return ess.sendEmailAttachment(eml); }
	 */
}
