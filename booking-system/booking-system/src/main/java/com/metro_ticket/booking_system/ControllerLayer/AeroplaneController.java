package com.metro_ticket.booking_system.ControllerLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metro_ticket.booking_system.Entity.Aeroplane;
import com.metro_ticket.booking_system.ServiceLayer.AeroplaneService;

@RestController
public class AeroplaneController {
	
	@Autowired
	public AeroplaneService service;
	
	@PostMapping("/add/aeroplane")
	public String add(@RequestBody List<Aeroplane> aero)
	{
		service.addaeroplane(aero);
		return "add one of the best Aeroplane";
	}
	
	@GetMapping("/get/aeroplane")
	public List<Aeroplane> get()
	{
		return service.getaeroplane();	
	}
	
	@PutMapping("updatebyid/{id}/{name}")
	public int modifybyid(int id,String name)
	{
		return service.getById(id, name);
	}

}
