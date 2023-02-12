package com.Springboot.FinalProject.OTT.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerid;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "subscriptionid")
	private Subscription subscription;

	
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Payment payment;
	
	
	
}


