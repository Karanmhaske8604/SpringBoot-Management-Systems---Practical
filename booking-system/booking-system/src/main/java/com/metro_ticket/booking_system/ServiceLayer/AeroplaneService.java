package com.metro_ticket.booking_system.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro_ticket.booking_system.Entity.Aeroplane;
import com.metro_ticket.booking_system.RepositoryLayer.AeroplaneRepo;

@Service
public class AeroplaneService {
	
	@Autowired
	private AeroplaneRepo repo;
	
	public String addaeroplane(List<Aeroplane> aeroplane)
	{
		repo.saveAll(aeroplane);
		return aeroplane.size()+" is added successfully";
	}
	
	public List<Aeroplane> getaeroplane()
	{
		return repo.findAll();
	}
	
	public int getById(int id,String name)
	{
		return repo.modifybyid(id,name);
	}
	

}
