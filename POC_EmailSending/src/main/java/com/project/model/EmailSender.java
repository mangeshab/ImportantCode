package com.project.model;

public class EmailSender {

	private String fromEmail;
	private String toEmail;
	private String subject;
	private String textMsg;
	public byte[] getFile;
	
	public byte[] getGetFile() {
		return getFile;
	}
	public void setGetFile(byte[] getFile) {
		this.getFile = getFile;
	}
	public String getFromEmail() {
		return fromEmail;
	}
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTextMsg() {
		return textMsg;
	}
	public void setTextMsg(String textMsg) {
		this.textMsg = textMsg;
	}
	
}
