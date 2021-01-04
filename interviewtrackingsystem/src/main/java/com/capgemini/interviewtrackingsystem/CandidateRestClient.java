package com.capgemini.interviewtrackingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.interviewtrackingsystem.model.Candidate;
@RestController
public class CandidateRestClient {
	

	   @Autowired
	   RestTemplate restTemplate;


	public void getCandidateDetails() {
	final String uri = "http://localhost:8080/managecandidate/";
	    	
	//final String uri = "http://localhost:8080/managecandidate/getCandidateById/1";
    RestTemplate restTemplate = new RestTemplate();
    
    
    HttpHeaders headers = new HttpHeaders();
   HttpEntity <String> entity = new HttpEntity<String>(headers);
    
     ResponseEntity<Candidate> response = restTemplate.getForEntity(uri, Candidate.class);
   System.out.println(response.getBody().toString());
  
	}
	public static void main(String[] args) {
		CandidateRestClient client= new CandidateRestClient();
		client.getCandidateDetails();
	}
}
