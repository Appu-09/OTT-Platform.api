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
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.repository.CustomerRepository;
import com.Springboot.FinalProject.OTT.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class Customercontroller {

	
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private CustomerRepository customerrepository;
	
	@PostMapping
	public Customer saveCustomer(@RequestBody CustomerDto customerDto) {
	 return customerservice.saveCustomer(customerDto);
	
	
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerservice.findAllCustomers();
     }
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable long id) {
		return customerservice.findbyCustomerId(id);
	}
	
	
	
	@DeleteMapping("/{customerId}")
	public int deleteCustomerByCustomerId(@PathVariable("customerId")long customerId){
	return customerservice.deleteCustomerByCustomerId(customerId);
	}

   @PutMapping("/customer/{id}")
   public Customer updateCustomer(@PathVariable long id,@RequestBody CustomerDto customerDto) {
	  return  customerservice.editCustomer(customerDto,id);
 		
  }
}
