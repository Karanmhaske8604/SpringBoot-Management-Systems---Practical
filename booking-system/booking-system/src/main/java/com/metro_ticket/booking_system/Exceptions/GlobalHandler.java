package com.metro_ticket.booking_system.Exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;


@RestControllerAdvice
public class GlobalHandler {

	//Global Level Handling
	
	@ExceptionHandler(TicketNotFound.class)
	public ResponseEntity<String> handleTicket(TicketNotFound tm)
	{
		return new  ResponseEntity<String>(tm.getMessage(),HttpStatus.PAYMENT_REQUIRED);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(CustomerNotFoundException ex)
	{
		ErrorResponse er=new ErrorResponse();
		
		er.setDate(LocalDateTime.now());
		er.setMessege(ex.getMessage());
		er.setStatus(HttpStatus.INSUFFICIENT_STORAGE);
		er.setTrace(ex.getStackTrace()[0].toString());
		
		return new ResponseEntity<ErrorResponse>(er,er.getStatus());
	}
	
	//Validation Exception Handle
	 
	@ExceptionHandler(HandlerMethodValidationException.class)
	public Map<String,String> handleHandlerMethodValidationException(HandlerMethodValidationException es) {
		
		Map<String, String> mp= new HashMap<String, String>();
		 
		es.getBeanResults().stream().forEach((i)->{mp.put(i.getFieldError().getField(), 
				i.getFieldError().getDefaultMessage());});
		
		return mp;
	}
	
	
	
}
