package com.metro_ticket.booking_system.ControllerLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metro_ticket.booking_system.Entity.Ticket;
import com.metro_ticket.booking_system.Exceptions.TicketNotFound;
import com.metro_ticket.booking_system.ServiceLayer.TicketService;

@RestController
public class TicketController {

	@Autowired
	public TicketService service;
	
	@PostMapping("/add/ticket")
	public String add(@RequestBody List<Ticket> ticket)
	{
		service.addticket(ticket);
		return "look! How many you got";
	}
	
	@GetMapping("/get/ticket")
	public List<Ticket> get()
	{
		return service.getticket();
	}
	
	@DeleteMapping("/delete/{id}")
	public int remove(@PathVariable(value="id") int id) throws TicketNotFound
	{
		return service.deleteByid(id);
	}
	
	@PutMapping("/update/{id}/{name}")
	public int update(@PathVariable(value="id")int id,@PathVariable(value="name") String name)
	{
		return service.updateByid(id, name);
	}
	
}
