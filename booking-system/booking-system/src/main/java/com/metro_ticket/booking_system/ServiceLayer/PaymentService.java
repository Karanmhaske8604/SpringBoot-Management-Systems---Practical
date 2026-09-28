package com.metro_ticket.booking_system.ServiceLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro_ticket.booking_system.Entity.Payment;
import com.metro_ticket.booking_system.RepositoryLayer.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo repo;
	
	public String addpayment(List<Payment> pay)
	{
		repo.saveAll(pay);
		return "Pay the price Bitch...";
	}
	
	public List<Payment> getpayment()
	{
		return repo.findAll();
	}

}
