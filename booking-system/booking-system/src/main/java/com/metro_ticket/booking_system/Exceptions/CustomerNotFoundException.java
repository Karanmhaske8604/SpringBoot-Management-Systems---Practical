package com.metro_ticket.booking_system.Exceptions;

public class CustomerNotFoundException extends Exception{
	
	
	public  CustomerNotFoundException(int id)
	{
		super("This "+id+" not found in list customers");
	}
	
	

}
