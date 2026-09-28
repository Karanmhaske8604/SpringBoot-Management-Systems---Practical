package com.metro_ticket.booking_system.Service_Test;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.metro_ticket.booking_system.Entity.Customer;
import com.metro_ticket.booking_system.ServiceLayer.CustomerService;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
public class CustomerService_Test {
	
	@Autowired 
	private CustomerService service;
	//Integration Test =>more than one layer
	
	@Test
	public void testaddcustomer()
	{
		Customer c=new Customer();
		c.setCname("Kumar Sanu");
		c.setEmail("kumar@gmail.com");
		c.setGender("male");
		c.setPhone(215556663);
		
		String s=service.addcustomer(c);
		
		assertNotNull(s);
	}
	
	@Test
	public void testsecond()
	{
		Customer c=new Customer();
		c.setCname("Kumar Sanu");
		c.setEmail("kumar@gmail.com");
		c.setGender("male");
		c.setPhone(215556663);
		
		service.addcustomer(c);
		
		List<Customer> list=service.getcustomer();
		
		assertNotEquals(3, list.size());
	}
	
	

}
