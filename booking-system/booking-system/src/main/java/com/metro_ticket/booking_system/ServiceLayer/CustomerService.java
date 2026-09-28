package com.metro_ticket.booking_system.ServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RestController;

import com.metro_ticket.booking_system.Entity.Customer;
import com.metro_ticket.booking_system.Exceptions.CustomerNotAvailableException;
import com.metro_ticket.booking_system.Exceptions.CustomerNotFoundException;
import com.metro_ticket.booking_system.RepositoryLayer.CustomerRepo;

@RestController
public class CustomerService {
	
	@Autowired
	private CustomerRepo repo;
	
	public String addcustomer(Customer c)
	{		
		repo.save(c);
		return c.getCname()+" to much is this.";
	}
	
	
	public List<Customer> getcustomer() 
	{
		return repo.findAll();
	}
	
	public Customer getbyid(int id) 
	{
		
		return repo.findById(id).get();
		
	}
	
			
	public int updateByid(int id,String name) throws CustomerNotAvailableException
	{ 
		if(repo.findById(id).isEmpty())
		{
			throw new CustomerNotAvailableException(name,id);
		}
		return repo.updatecust(id,name);
	}
	
	public int deletebyid(int id) throws CustomerNotFoundException
	{
		Optional<Customer> op = repo.findById(id);
		if(op.isEmpty())
		{
			throw new CustomerNotFoundException(id);
		}
		return repo.deletecust(id);
	}
	
	
	//Pagenation And Sorting
	public Page<Customer> getPage(int num, String direction)
	{
		Sort sort ;
		if(direction.startsWith("a") ||  direction.startsWith("A"))
		{		
			sort=Sort.by(Direction.ASC, "cid");
		}
		else
		{
			sort=Sort.by(Direction.DESC, "cid");
		}
		
		Page<Customer> page=repo.findAll(PageRequest.of(num,4,sort));
		
		return page;
	}
	

}
