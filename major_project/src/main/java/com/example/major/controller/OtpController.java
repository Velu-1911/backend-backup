package com.example.major.controller;


import com.twilio.rest.api.v2010.account.Message;
import com.example.major.entity.users;
import com.example.major.service.UserService;
import com.twilio.Twilio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.net.URI;
@RestController
//@Controller
@RequestMapping(path = "api/v1")
public class OtpController {
	
	
	private final UserService userService;

	@Autowired
	public OtpController(UserService userService) {
		this.userService = userService;
	}
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/otp")
	public ResponseEntity<String> OTP(@RequestBody users user){
		//System.out.println("otp checker");
		System.out.println(user);
		return (ResponseEntity<String>) userService.OtpGenerator(user);

	}

}
