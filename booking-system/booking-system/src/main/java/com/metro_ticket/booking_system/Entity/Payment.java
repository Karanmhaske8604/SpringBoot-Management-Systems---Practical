package com.metro_ticket.booking_system.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;


@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;

	UUID tnumber=UUID.randomUUID();
	
	String status;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public UUID getTnumber() {
		return tnumber;
	}
	public void setTnumber(UUID tnumber) {
		this.tnumber = tnumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	//For Customer
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	//for Ticket
	@OneToOne(mappedBy = "pay")
	private Ticket tic;
	

}
