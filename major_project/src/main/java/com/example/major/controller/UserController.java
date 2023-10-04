package com.example.major.controller;

//import java.util.List;


//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.major.entity.users;
import com.example.major.service.UserService;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {
	
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//you inserted this line to avoid cross origins error(cors error not in the video).
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/users")
	public ResponseEntity<String> Login(@RequestBody users User) {
		return (ResponseEntity<String>) userService.login(User);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value = "/signup")
	public ResponseEntity<String> Signup(@RequestBody users User) {
		//System.out.println(User);
		return (ResponseEntity<String>) userService.signup(User);
	}
	
	
	

}
