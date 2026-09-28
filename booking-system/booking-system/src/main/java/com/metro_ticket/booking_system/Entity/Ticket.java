package com.metro_ticket.booking_system.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tid;
	
	double price;
	String destination;
	String boarding;
	
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getBoarding() {
		return boarding;
	}
	public void setBoarding(String boarding) {
		this.boarding = boarding;
	}
	
	//For Aeroplane
	@ManyToOne
	@JoinColumn(name="plane_id")
	 private Aeroplane plane;
	
	//For Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	//For Payment
	@OneToOne
	@JoinColumn(name="payment_id")
	private Payment pay;
	
	
	
	

}
