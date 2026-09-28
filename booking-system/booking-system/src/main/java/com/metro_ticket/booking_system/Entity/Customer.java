package com.metro_ticket.booking_system.Entity;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;

@Entity
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid; 
	
	@Length(min=3,max=20,message="fill neat value")
	String cname;
	
	@Email(message = "ky lakaaa!!!!")
	String email;
	
	
	long phone;
	String gender;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	//For Ticket
	@OneToMany(mappedBy = "customer")
	private List<Ticket> tick;
	
	//For Payments
	@OneToMany(mappedBy = "customer")
	private List<Payment> payment;
	
	
	

}
