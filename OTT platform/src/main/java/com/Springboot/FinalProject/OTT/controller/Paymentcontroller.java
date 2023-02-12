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

import com.Springboot.FinalProject.OTT.dto.PaymentDto;
import com.Springboot.FinalProject.OTT.dto.SubscriptionDto;
import com.Springboot.FinalProject.OTT.entity.Payment;
import com.Springboot.FinalProject.OTT.entity.Subscription;
import com.Springboot.FinalProject.OTT.repository.PaymentRepository;
import com.Springboot.FinalProject.OTT.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class Paymentcontroller {

	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PaymentRepository paymentRepository;
	
	@PostMapping
	 public Payment savePayment(@RequestBody PaymentDto paymentDto) {
        return paymentService.savePayment(paymentDto);
    }
	
	@GetMapping
	public List<Payment>getAllPayments(){
		return paymentService.findAllPayments();
	}
	
	@GetMapping("/payment/{id}")
	public Payment getPaymentById(@PathVariable  long id) {
	return paymentService.findbyPaymentId(id);
	}
	
	
	
	@DeleteMapping("/{paymentid}")
	public int deletePaymentByPaymentId(@PathVariable("paymentId")long paymentId) {
		return paymentService.deletePaymentByPaymentId(paymentId);
	}
	
	
	 @PutMapping("/payment/{id}")
	   public Payment updatePayment(@PathVariable long id,@RequestBody PaymentDto paymentDto) {
		  return  paymentService.editPayment(paymentDto,id);
	 		
	 }
}
	

