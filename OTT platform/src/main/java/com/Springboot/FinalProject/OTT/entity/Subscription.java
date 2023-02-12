package com.Springboot.FinalProject.OTT.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscription")
public class Subscription {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long subscriptionid;
	private String subscriptiontype;
	private int price;
	@JsonIgnore
	@OneToMany(mappedBy = "subscription",cascade =  CascadeType.ALL)
	private List<Customer> customers;
	@JsonIgnore
	@OneToMany(mappedBy = "subscription")
	private List<Payment> payments;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "subscription_content",
			joinColumns = @JoinColumn(name = "subscriptionid"),inverseJoinColumns = @JoinColumn(name = "contentid"))
	private List<Content> contents;
}

