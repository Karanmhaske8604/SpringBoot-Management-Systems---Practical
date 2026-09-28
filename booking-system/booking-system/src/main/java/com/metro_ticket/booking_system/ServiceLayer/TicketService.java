package com.metro_ticket.booking_system.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro_ticket.booking_system.Entity.Ticket;
import com.metro_ticket.booking_system.Exceptions.TicketNotFound;
import com.metro_ticket.booking_system.RepositoryLayer.TicketRepo;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepo repo;
	
	public String addticket(List<Ticket> ticket)
	{
		repo.saveAllAndFlush(ticket);
		return ticket.size()+" Done!";
	}
	
	public List<Ticket> getticket()
	{
		return repo.findAll();
	}
	
	//deleteById
	public int deleteByid(int id)throws TicketNotFound
	{
		if(repo.findById(id).isEmpty())
		{
			throw new TicketNotFound(id);
		}
		return repo.deleteid(id);
	}
	
	//updateById
	public int updateByid(int id,String name)
	{
		return repo.updateplace(id,name);
	}

}
