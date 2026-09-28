package com.metro_ticket.booking_system.RepositoryLayer;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metro_ticket.booking_system.Entity.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Modifying
	@Transactional
	@Query(value="update customer set email= :name where cid= :id",nativeQuery=true)
	int updatecust( @Param(value="id") int id,@Param(value="name")String name);
	
	@Modifying
	@Transactional
	@Query(value="delete from customer where cid= :id;",nativeQuery=true)
	int deletecust(@Param(value="id") int id);

	
	@Modifying
	@Transactional
	@Query(value="delete from customer where cid= :i;",nativeQuery=true)
	Customer deleteById(@Param(value="i") int i);

	
}
