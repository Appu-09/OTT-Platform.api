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
@Table(name = "payment")
public class Payment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentid;
	private int amount;
	private long billingdate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subscriptionId")
	private Subscription subscription;
	
	
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
}
