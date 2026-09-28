package com.metro_ticket.booking_system.Exceptions;

public class CustomerNotAvailableException extends Exception {
	
	public CustomerNotAvailableException(String name,int id)
	{
		super("Can't update this "+id+" Customer beacause this "+ name+" is not present");
	}

}
