package com.Springboot.FinalProject.OTT.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDto {
	private String subscriptiontype;
	private int price;
}
