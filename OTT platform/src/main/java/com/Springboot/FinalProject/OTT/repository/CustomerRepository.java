package com.Springboot.FinalProject.OTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.FinalProject.OTT.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

	
	// Customer delete(Long customerId);
	int deleteByCustomerid(long customerId);

	
	
}

