package com.Springboot.FinalProject.OTT.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.http.HttpHeaders;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerTest {

	@Autowired
	private TestRestTemplate template;
	@Test
	void getAllCustomers_test() throws JSONException {
	
				
 
		ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/customer", String.class);
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		
		

	}
	@Test
	void addCustomers_test()  {
		String body = """
			{
					  "firstname": "string",
					  "lastName": "string",
					  "username": "string",
					  "email": "string",
					  "password": "string",
					  "subscriptionId": 1
					}
				
				""";
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
	   httpHeaders.add("Content-Type","application/json");
	   HttpEntity<String> httpEntity = new HttpEntity<>(body,httpHeaders);
	   ResponseEntity<String> responseEntity = template.exchange("http://localhost:8080/customer",HttpMethod.POST,httpEntity,String.class );
	   assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	   
	}
}


