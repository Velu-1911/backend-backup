package com.example.major.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.major.entity.Customers;
import com.example.major.entity.users;
import com.example.major.repository.CustomerRepository;

@Service
public class CustomerService {
	
	
	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public List<Customers> getall() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}


	public ResponseEntity<String> CustomerValidation(Customers customer) {
		System.out.println(customer);
		
		Optional<Customers> current = customerRepository.findCustomerByaccountNum(customer.getAccountNumber());
		if(current.isPresent()) {
			System.out.println(current);
			Customers check = current.get();
			if(check.getName().equals(customer.getName())){
				
				return (ResponseEntity<String>) ResponseEntity.ok("Login Successfull");
				
			}
			else {
				return (ResponseEntity<String>) ResponseEntity.ok("Account holder name is wrong");
			}
						
		}
		else {
			return (ResponseEntity<String>) ResponseEntity.ok("account number does not exist");
	
		}
		

	}
	
	
	

}
