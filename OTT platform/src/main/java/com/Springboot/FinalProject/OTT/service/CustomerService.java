package com.Springboot.FinalProject.OTT.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.FinalProject.OTT.dto.CustomerDto;
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.entity.Subscription;
import com.Springboot.FinalProject.OTT.repository.CustomerRepository;
import com.Springboot.FinalProject.OTT.repository.SubscriptionRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

	
	@Autowired
	private  CustomerRepository customerrepository;
	@Autowired
	private SubscriptionRepository subscriptionrepository;
	
	private ModelMapper modelMapper =new ModelMapper();
	
	public Customer saveCustomer(CustomerDto customerDto) {
//		Customer customer2=new Customer();
//		customer2.setEmail(customerDto.getEmail());
//		customer2.setFirstName(customerDto.getFirstName());
//		customer2.setLastName(customerDto);
  
		Customer customer2=modelMapper.map(customerDto,Customer.class);
		
		Subscription sub = subscriptionrepository.findById(customerDto.getSubscriptionId()).get();
		
		customer2.setSubscription(sub);
		return customerrepository.save(customer2);
	}
	public List<Customer>listCustomer(Customer customer){
		return customerrepository.findAll();
	}
	
	@Transactional
	public int deleteCustomerByCustomerId(long customerId) {
		return customerrepository.deleteByCustomerid(customerId);
	}
	public List<Customer> findAllCustomers(){
		return customerrepository.findAll();
	}
	public Customer findbyCustomerId(long customerId) {
		return (Customer) customerrepository.findById(customerId).get();
	}
	public Customer editCustomer(CustomerDto customerDto, long id) {
		Customer customer = customerrepository.findById(id).get();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setPassword(customerDto.getPassword());
		customer.setEmail(customerDto.getEmail());
		
		
		Subscription sub1 = subscriptionrepository.findById(customerDto.getSubscriptionId()).get();
		
		customer.setSubscription(sub1);
		return customerrepository.save(customer);
		
	}
	}
    
     
	