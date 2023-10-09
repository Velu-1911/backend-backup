package com.example.major.configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.major.entity.users;

import com.example.major.repository.UserRepository;

@Configuration
public class usersConfiguration {
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository ) {
		return args ->{
			users velu = new users(
					"velu@gmail.com",
					"+911111111111",
					"hello",
					"Velu",
					1
					);
			
			users guru = new users(
					"guru@gmail.com",
					"+911234567890",
					"hello",
					"guru",
					2
					);
			
			userRepository.saveAll(List.of(velu,guru));
			
			
		};

	}

}
