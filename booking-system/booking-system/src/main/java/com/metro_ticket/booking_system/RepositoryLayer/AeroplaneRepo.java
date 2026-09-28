package com.metro_ticket.booking_system.RepositoryLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metro_ticket.booking_system.Entity.Aeroplane;

import jakarta.transaction.Transactional;

@Repository
public interface AeroplaneRepo extends JpaRepository<Aeroplane, Integer>{
	
	@Modifying
	@Transactional
	@Query(value="update aeroplane set modelname= :name where id= :id;",nativeQuery=true)
	int modifybyid(@Param(value="id") int id,@Param(value="name") String name);

}
