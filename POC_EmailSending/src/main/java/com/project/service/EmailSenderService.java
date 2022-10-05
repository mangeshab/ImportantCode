package com.project.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.project.model.EmailSender;

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender javamailsender;
	
	public void sendEmail(EmailSender e)
	{
		SimpleMailMessage mailmessage=new SimpleMailMessage();
		mailmessage.setFrom(e.getFromEmail());
		mailmessage.setTo(e.getToEmail());
		mailmessage.setSubject(e.getSubject());
		mailmessage.setText(e.getTextMsg());
		
		javamailsender.send(mailmessage);
		System.out.println("Email Successfully Sent...!!!");
	}
	/*
	 * public String sendEmailAttachment(EmailSender eml) { MimeMessage
	 * message=javamailsender.createMimeMessage(); try { MimeMessageHelper
	 * helper=new MimeMessageHelper(message,true);
	 * 
	 * helper.setFrom(eml.getFromEmail()); helper.setTo(eml.getToEmail());
	 * helper.setSubject(eml.getSubject()); helper.setText(eml.getTextMsg());
	 * 
	 * FileSystemResource file=new FileSystemResource("D:\\mangesh.docx");
	 * helper.addAttachment(file.getFilename(),file); javamailsender.send(message);
	 * 
	 * } catch(MessagingException e) { throw new MailParseException(e); } return
	 * "Email send"; }
	 */}
