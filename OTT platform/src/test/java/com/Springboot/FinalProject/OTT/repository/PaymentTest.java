package com.Springboot.FinalProject.OTT.repository;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PaymentTest {

	

	@Autowired
	private TestRestTemplate template;
	@Test
	void getAllPayments_test() throws  JSONException{
		
		
		ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/movies", String.class);
		assumeTrue(responseEntity.getStatusCode().is2xxSuccessful());
	

	}
}
