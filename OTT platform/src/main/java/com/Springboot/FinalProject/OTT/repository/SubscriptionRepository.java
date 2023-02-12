package com.Springboot.FinalProject.OTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.FinalProject.OTT.entity.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository <Subscription,Long>{

	int deleteBySubscriptionid(long subscriptionId);

}
