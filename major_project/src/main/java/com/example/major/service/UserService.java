package com.example.major.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.major.entity.users;
import com.example.major.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
//	public Optional<users> getUsers(){
//		return userRepository.findStudentLogin("guru@gmail.com", "hello");
//	}

	

	public ResponseEntity<String> login(users user) {
		//System.out.println(user);
		Optional<users> current = userRepository.findStudentByEmail(user.getEmail());
		Optional<users> current1 = userRepository.findStudentByPhone(user.getEmail());
		if(current.isPresent()) {
			
			users check = current.get();
			System.out.println(check);
			if(check.getPassword().equals(user.getPassword())) {
				return (ResponseEntity<String>) ResponseEntity.ok("Login succesfull");
			}
			else {
				return (ResponseEntity<String>) ResponseEntity.ok("password does not match");
			}
			
		}else if(current1.isPresent()){
			users check = current1.get();
			System.out.println(check);
			if(check.getPassword().equals(user.getPassword())) {
				return (ResponseEntity<String>) ResponseEntity.ok("Login succesfull");
			}
			else {
				return (ResponseEntity<String>) ResponseEntity.ok("password does not match");
			}
		}else {
			return (ResponseEntity<String>) ResponseEntity.ok("phone/email does not exist");
		}
		
		// TODO Auto-generated method stub
		
	}

	public ResponseEntity<String> signup(users user) {
		// TODO Auto-generated method stub
		//complete signup logic today.
		System.out.println(user);
		Optional<users> Email_check = userRepository.findStudentByEmail(user.getEmail());
		Optional<users> Phone_check = userRepository.findStudentByPhone(user.getPhonenumber());
		System.out.println(user);
		System.out.println(Email_check );
		System.out.println(Phone_check );
		if(Email_check.isPresent()) {
			return (ResponseEntity<String>) ResponseEntity.ok("Email already exist");
		}else if(Phone_check.isPresent()) {
			return (ResponseEntity<String>) ResponseEntity.ok("Phone number already exists");
		}
		else if(user.getPhonenumber().length()!=10) {
			return (ResponseEntity<String>) ResponseEntity.ok("Phone number should be of 10 digits");
		}
		else {
			userRepository.save(user);
		}
		return (ResponseEntity<String>) ResponseEntity.ok("Object Created");

	};
	
}
