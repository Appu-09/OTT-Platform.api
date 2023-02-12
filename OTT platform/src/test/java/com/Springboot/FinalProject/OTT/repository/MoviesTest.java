package com.Springboot.FinalProject.OTT.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.checkerframework.checker.units.qual.h;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MoviesTest {

	
	@Autowired
	private TestRestTemplate template;
	@Test
	void getAllMovies_test() throws  JSONException{
		
		
		ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/movies", String.class);
		assumeTrue(responseEntity.getStatusCode().is2xxSuccessful());
	
}
	@Test
	void addMovies_test() {
		String body = """
				{
  "duration": 2,
  "movieName": "Bahubali",
  "genres": [
    1,2
  ],
  "genreId": 1
}
				""";
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		httpHeaders.add("Content-Type","application/json");
		HttpEntity<String> httpEntity = new HttpEntity<>(body,httpHeaders);
		ResponseEntity<String> responseEntity = template.exchange("http://localhost:8080/movies", HttpMethod.POST,httpEntity,String.class);
		
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}
	
}
