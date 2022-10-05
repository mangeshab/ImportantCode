package com.project.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {
	private int statuscode;
	private Date tdate;
	private String errormsg;
	private String path;
	private HttpStatus error;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public HttpStatus getError() {
		return error;
	}
	public void setError(HttpStatus error) {
		this.error = error;
	}
	public ApiError(int statuscode, Date tdate, HttpStatus error, String path, String errormsg) {

		this.statuscode = statuscode;
		this.tdate = tdate;
		this.errormsg = errormsg;
		this.path = path;
		this.error = error;
	}
	public ApiError() {
		
	}
	

}
