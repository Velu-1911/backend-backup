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
		Optional<Customers> current1 = customerRepository.findCustomerByName(customer.getName());
		if(current.isPresent()) {
			System.out.println(current);
			Customers check = current.get();
			if(check.getName().equals(customer.getName())){

				return (ResponseEntity<String>) ResponseEntity.ok("Login Successfull");

			}
			else if(current1.isPresent())
			{
				return (ResponseEntity<String>) ResponseEntity.ok("Account holder name/number is incorrect");
			}
			else{
				return (ResponseEntity<String>) ResponseEntity.ok("Account holder name is wrong");
			}

		}
		else {
			return (ResponseEntity<String>) ResponseEntity.ok("account number does not exist");

		}


 

	}
	
	public Customers getphoneEmail(Customers customer) {

		// TODO Auto-generated method stub

		 Optional<Customers> acctcheck = customerRepository.findCustomerByaccountNum(customer.getAccountNumber());

		 Customers c = acctcheck.get();

		 Customers cust = new Customers();

		 cust.setEmail(c.getEmail());

		 cust.setphonenumber(c.getphonenumber());

		 cust.setName(c.getName());

		 cust.setphonenumber(c.getphonenumber());

		 System.out.print(cust);

		 return cust;

	}




 

}
	

