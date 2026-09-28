package com.metro_ticket.booking_system.ControllerLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metro_ticket.booking_system.Entity.Payment;
import com.metro_ticket.booking_system.ServiceLayer.PaymentService;

@RestController
public class PaymentController {
	
	
	@Autowired
	public PaymentService service;
	
	@PostMapping("/add/payment")
	public String add(@RequestBody List<Payment> pay)
	{
		service.addpayment(pay);
		return "Weldone you Bitch..";
	}
	
	@GetMapping("/get/payment")
	public List<Payment> get()
	{
		return service.getpayment();
	}
	
	
}
