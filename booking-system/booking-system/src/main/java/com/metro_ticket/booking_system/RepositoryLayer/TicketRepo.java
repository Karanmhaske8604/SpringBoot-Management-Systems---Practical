package com.metro_ticket.booking_system.RepositoryLayer;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metro_ticket.booking_system.Entity.Ticket;

import jakarta.transaction.Transactional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="delete from ticket where tid= :id",nativeQuery=true)
	int deleteid(@Param(value="id") int id);
	
	@Modifying
	@Transactional
	@Query(value="update ticket set destination = :place where tid= :id;",nativeQuery=true)
	int updateplace(@Param(value="id") int id, @Param(value="place") String place);
	
	

}
