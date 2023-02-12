package com.Springboot.FinalProject.OTT.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.FinalProject.OTT.dto.GenreDto;
import com.Springboot.FinalProject.OTT.dto.PaymentDto;
import com.Springboot.FinalProject.OTT.dto.SubscriptionDto;
import com.Springboot.FinalProject.OTT.dto.SubscriptionResponseDto;
import com.Springboot.FinalProject.OTT.entity.Customer;
import com.Springboot.FinalProject.OTT.entity.Genre;
import com.Springboot.FinalProject.OTT.entity.Payment;
import com.Springboot.FinalProject.OTT.entity.Subscription;
import com.Springboot.FinalProject.OTT.repository.CustomerRepository;
import com.Springboot.FinalProject.OTT.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {


	@Autowired
	private  PaymentRepository paymentrepository;
		private ModelMapper modelMapper = new ModelMapper();
		
		public Payment  savePayment(PaymentDto paymentDto) {
		//Payment payment1= new Payment();
		//payment1.setAmount(paymentDto.getAmount());
		//payment1.setBillingDate(paymentDto.getBillingDate());
		Payment payment1 = modelMapper.map(paymentDto,Payment.class);
		
		Payment save = paymentrepository.save(payment1);
		
			return save;
	}
	public List<Payment>listPayment(Payment payment){
		return paymentrepository.findAll();
	}
	
	@Transactional
	public int deletePaymentByPaymentId(long paymentId) {
		return paymentrepository.deletePaymentByPaymentid(paymentId);
	}
	public List<Payment> findAllPayments() {
		
		return paymentrepository.findAll();
	}
	public Payment findbyPaymentId(long paymentId) {
		
		return (Payment) paymentrepository.findById(paymentId).get();
	}
	
	public Payment editPayment(PaymentDto paymentDto, long id) {
		Payment payment = paymentrepository.findById(id).get();
		payment.setAmount(paymentDto.getAmount());
		payment.setBillingdate(paymentDto.getBillingdate());
			return paymentrepository.save(payment);
	
	}
}
