package com.Springboot.FinalProject.OTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.FinalProject.OTT.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository <Payment,Long> {

	int deletePaymentByPaymentid(long paymentId);

}
