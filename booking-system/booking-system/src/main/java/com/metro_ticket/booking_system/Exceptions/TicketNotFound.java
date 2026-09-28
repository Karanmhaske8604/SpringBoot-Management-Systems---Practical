package com.metro_ticket.booking_system.Exceptions;


public class TicketNotFound extends Exception{
	
	public TicketNotFound(int id)
	{
		super("Can't delete id: "+id+" beacause it is not present.");
	}

}
