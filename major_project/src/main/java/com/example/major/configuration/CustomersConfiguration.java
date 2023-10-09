package com.example.major.configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.major.entity.Customers;
import com.example.major.repository.CustomerRepository;

@Configuration
public class CustomersConfiguration {
	
	
	@Bean
	CommandLineRunner commandLineRunner33(CustomerRepository customerRepository) {
		return args->{
			Customers velu = new Customers(
					"velu",
					"f-7 gr flats",
					"velu@gmail.com",
					"+911111111111",
					1
										
					);
			
			Customers guru = new Customers(
					"guru",
					"f-7 gr flats",
					"guru@gmail.com",
					"+911234567890",
					2										
					);
			
			Customers isu = new Customers(
					"iswarya",
					"f-7 gr flats",
					"isu@gmail.com",
					"+918428984718",
					3										
					);
			customerRepository.saveAll(List.of(velu,guru,isu));
			
		};
	}

}
