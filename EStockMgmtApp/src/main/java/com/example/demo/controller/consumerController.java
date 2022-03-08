package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;

@RestController
@RequestMapping("/auth/v1")
public class consumerController {
	/*
	
	private static HttpEntity<Object> entity;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@PostMapping("/login")
	public String getToken(@RequestBody User user) throws RestClientException, Exception{
		String response=null;
		List<ServiceInstance> instances = discoveryClient.getInstances("user-producer");
		ServiceInstance serviceInstance = instances.get(0);		
		String baseUrl = serviceInstance.getUri().toString();
		System.out.println("base url is "+baseUrl);
		baseUrl = "http://user-producer/auth/v1/login";
		
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set("Accept",MediaType.APPLICATION_JSON_VALUE);
			headers.set("Content-Type",MediaType.APPLICATION_JSON_VALUE);
			entity = new HttpEntity<>(user,headers);
			response = restTemplate.exchange(baseUrl,HttpMethod.POST, entity, String.class).getBody();
		}
		catch(Exception e) {
			e.printStackTrace();
		}		
		System.out.println("body is");
		System.out.println(baseUrl);
		System.out.println(response);
		return response;
	} */

}
