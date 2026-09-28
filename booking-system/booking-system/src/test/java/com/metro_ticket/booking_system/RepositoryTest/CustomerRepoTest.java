package com.metro_ticket.booking_system.RepositoryTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.metro_ticket.booking_system.Entity.Customer;
import com.metro_ticket.booking_system.RepositoryLayer.CustomerRepo;

@DataJpaTest
public class CustomerRepoTest {
	
	
	//Unit Test =>only Specific class
	@Autowired
	private CustomerRepo repo;
	
	@Test
	public void addCustomer()
	{
		Customer cust=new Customer();
		cust.setCname("Sai Pawar");
		cust.setEmail("sai@gmail.com");
		cust.setGender("Female");
		cust.setPhone(902164494);
		
		Customer c2=repo.save(cust);
		
		assertNotNull(c2);
	}
	
	@Test
	public void checkcustomer()
	{
		Customer cust=new Customer();
		cust.setCname("Sama Salavi");
		cust.setEmail("samuu@gmail.com");
		cust.setGender("male");
		cust.setPhone(985364494);
		
		int c=repo.updatecust(3,"Sama Salavi");
		
		assertNotEquals(1, c);
	}
	

}
