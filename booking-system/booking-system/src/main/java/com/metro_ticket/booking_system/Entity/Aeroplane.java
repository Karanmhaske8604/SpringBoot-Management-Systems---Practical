package com.metro_ticket.booking_system.Entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Aeroplane {
	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String modelname;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	
	//For Ticket
	@OneToMany(mappedBy = "plane")
	private List<Ticket> tickets;
	

}
