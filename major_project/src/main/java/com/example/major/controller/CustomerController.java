package com.example.major.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.major.entity.Customers;
import com.example.major.service.CustomerService;

@RestController
@RequestMapping(path = "api/v1")
public class CustomerController {
	
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//you inserted this line to avoid cross origins error(cors error not in the video).
	

	@GetMapping(value = "/customers")
	public List<Customers> getCustomers(){
		 return customerService.getall();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/customers")
	public ResponseEntity<?> Signup(@RequestBody Customers customer){
		return (ResponseEntity<String>) customerService.CustomerValidation(customer);
		
	}
	
	
	
	
}
