package com.Springboot.FinalProject.OTT.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private long subscriptionId;

}
