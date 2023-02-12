package com.Springboot.FinalProject.OTT.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
public class TvshowsTest {

	@Autowired
	private TestRestTemplate template;
	@Test
	void getAllTvShows_test() throws  JSONException{

		
		ResponseEntity<String> responseEntity = template.getForEntity("http://localhost:8080/tvshows", String.class);
		assumeTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}
	@Test
	void addMovies_test() {
		String body = """
				{
  {
  "noofseasons": 2,
  "genres": [
    1,2
  ],
  "genreId": 1
}
}
				""";
		org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
		httpHeaders.add("Content-Type","application/json");
		HttpEntity<String> httpEntity = new HttpEntity<>(body,httpHeaders);
		ResponseEntity<String> responseEntity = template.exchange("http://localhost:8080/tvshows", HttpMethod.POST,httpEntity,String.class);
		
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
	}
	


}

