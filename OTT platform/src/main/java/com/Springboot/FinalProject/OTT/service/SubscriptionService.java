package com.Springboot.FinalProject.OTT.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.FinalProject.OTT.dto.CustomerDto;
import com.Springboot.FinalProject.OTT.dto.GenreDto;
import com.Springboot.FinalProject.OTT.dto.SubscriptionDto;
import com.Springboot.FinalProject.OTT.dto.SubscriptionResponseDto;
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.entity.Subscription;
import com.Springboot.FinalProject.OTT.repository.SubscriptionRepository;

import jakarta.transaction.Transactional;


@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionrepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	public SubscriptionResponseDto  saveSubscription(SubscriptionDto subscriptionDto) {
	//Subscription subscription2= new Subscription();
		//subscription2.setSubscriptiontype(subscriptionDto.getSubscriptiontype());
	    //subscription2.setPrice(subscriptionDto.getPrice());
		Subscription subscription2 = modelMapper.map(subscriptionDto,Subscription.class);
		
		Subscription save = subscriptionrepository.save(subscription2);
		SubscriptionResponseDto responseDto=modelMapper.map(save,SubscriptionResponseDto.class);
		
			return responseDto;
	}
	
	
//   private ModelMapper modelMapper1 = new ModelMapper();
//   public Subscription saveSubscription(SubscriptionDto subscriptionResponseDto) {
//	   
//	 // Subscription subscription3 = new Subscription();
//	   //subscription3.setSubscriptionttype(subscriptionResponseDto.getSubscriptiontype());
//	   //subscription3.setPrice(subscriptionResponseDto.getPrice());
//	   //subscription3.setSubscriptionId(subscriptionResponseDto.getSubscriptionId());
//	   Subscription subscription3 = modelMapper1.map(subscriptionResponseDto,Subscription. class);
//	   
//	   Subscription save = subscriptionrepository.save(subscription3);
//	   
//	   return save;
//   }
    
	public Subscription saveSubscription(Subscription subscription) {
		return subscriptionrepository.save(subscription);
	}
	
	public List<Subscription> listSubscription(Subscription subscription){
		return subscriptionrepository.findAll();
	}
	
	@Transactional
	public int deleteSubscriptionBySubscriptionId(long subscriptionId) {
		return subscriptionrepository.deleteBySubscriptionid(subscriptionId);
	}


	public Subscription findbySubscriptionId(long subscriptionId) {
		return (Subscription) subscriptionrepository.findById(subscriptionId).get();
		
	}


	public List<Subscription> findAllSubscriptions() {
		// TODO Auto-generated method stub
		return subscriptionrepository.findAll();
	}


		
		public Subscription editSubscription(SubscriptionDto subscriptionDto, long id) {
			Subscription subscription = subscriptionrepository.findById(id).get();
			subscription.setSubscriptiontype(subscriptionDto.getSubscriptiontype());
			subscription.setPrice(subscriptionDto.getPrice());
				return subscriptionrepository.save(subscription);
			
	}
}
