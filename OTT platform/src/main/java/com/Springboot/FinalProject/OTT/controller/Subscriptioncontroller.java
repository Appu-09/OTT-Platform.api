package com.Springboot.FinalProject.OTT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.FinalProject.OTT.dto.CustomerDto;
import com.Springboot.FinalProject.OTT.dto.SubscriptionDto;
import com.Springboot.FinalProject.OTT.dto.SubscriptionResponseDto;
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.entity.Subscription;
import com.Springboot.FinalProject.OTT.repository.SubscriptionRepository;
import com.Springboot.FinalProject.OTT.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class Subscriptioncontroller {


	@Autowired
	private SubscriptionService subscriptionservice;
	
	@Autowired
	private SubscriptionRepository subscriptionrepository;
	
	@PostMapping
	public SubscriptionResponseDto saveSubscriptionDto(@RequestBody SubscriptionDto  subscriptionDto) {
		 
		return  subscriptionservice.saveSubscription(subscriptionDto);
	}

	@GetMapping
	public List<Subscription>getAllSubscriptions(){
		return subscriptionservice.findAllSubscriptions();
	}
	
	
	@GetMapping("/subscription/{id}")
	public Subscription getSubscriptionById(@PathVariable  long id){
		return subscriptionservice.findbySubscriptionId(id);
	}
	
	
	
	
	@DeleteMapping("/{subscriptionId}")
	public int deleteSubscriptionBySubscriptionId(@PathVariable("subscriptionId")long subscriptionId){
	return subscriptionservice.deleteSubscriptionBySubscriptionId(subscriptionId);
	}
	
	
	 @PutMapping("/subscription/{id}")
	   public Subscription updateSubscription(@PathVariable long id,@RequestBody SubscriptionDto subscriptionDto) {
		  return  subscriptionservice.editSubscription(subscriptionDto,id);
	 		
	 }
}
