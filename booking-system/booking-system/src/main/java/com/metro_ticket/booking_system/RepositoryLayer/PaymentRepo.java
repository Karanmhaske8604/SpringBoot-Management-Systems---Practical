package com.metro_ticket.booking_system.RepositoryLayer;




import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import com.metro_ticket.booking_system.Entity.Payment;



@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{
	
	
	

}
