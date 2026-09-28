package com.metro_ticket.booking_system.ControllerLayer;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.metro_ticket.booking_system.Entity.Customer;
import com.metro_ticket.booking_system.Exceptions.CustomerNotAvailableException;
import com.metro_ticket.booking_system.Exceptions.CustomerNotFoundException;
import com.metro_ticket.booking_system.ServiceLayer.CustomerService;
import jakarta.validation.Valid;

@RestController
public class CustomerController {

	@Autowired
	public CustomerService service;
	
	Logger log=LoggerFactory.getLogger(CustomerController.class);
		
	@PostMapping("/add/customer")
	@CacheEvict(value="Customers",key="'all'")
	public String add(@Valid @RequestBody Customer cust)
	{
		log.info("Nothing to worry bro!");
		service.addcustomer(cust);
		return "Welcome on Board !!";
	}
		
	@GetMapping("/get/customer")
	@Cacheable(value="Customers", key="'all'")
	public List<Customer> get() throws InterruptedException 
	{
		Thread.sleep(10000);
		return service.getcustomer();
	}
	
	
	
	@PutMapping("/modify/{id}/{name}") 
	//@CachePut(value="Customers" ,key="#id")
	@CacheEvict(value="Customers" ,key="#id")
	public int updateby(int id,String name)throws CustomerNotAvailableException
	{
		return service.updateByid(id, name);
	}
	
	
	@DeleteMapping("/remove/{id}")
	@CacheEvict(value="Customers" ,key="#id")
	public int remove(int id) throws  CustomerNotFoundException
	{
		return service.deletebyid(id);
	}
	
	@GetMapping("/get-by-id/{id}")
	@Cacheable(value="Customers",key="#id")
	public Customer getbyid(@PathVariable(value="id")int id) throws InterruptedException
	{
		Thread.sleep(5000);
		return service.getbyid(id);
		
	}
	
	//Local level Handling
	@ExceptionHandler(value=CustomerNotAvailableException.class)
	public ResponseEntity<String> HandleResponse(CustomerNotAvailableException ex)
	{
		return new  ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	//Pagenation & Sorting
	@GetMapping("/get-page-customer")
	public Page<Customer> getCust(@RequestParam("page")int num,@RequestParam("direction") String direction)
	{
		return service.getPage(num,direction);
	}
	
}
