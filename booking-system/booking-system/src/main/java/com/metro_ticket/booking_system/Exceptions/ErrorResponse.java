package com.metro_ticket.booking_system.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;


public class ErrorResponse {
	
	LocalDateTime date;
	String messege;
	HttpStatus status;
	String trace;
	
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getTrace() {
		return trace;
	}
	public void setTrace(String trace) {
		this.trace = trace;
	}
	
	


}
