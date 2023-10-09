package com.example.major.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.major.dto.RouterLogin;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Routers;
import com.example.major.service.RouterService;

@RestController
@RequestMapping(path = "api/router")
public class RouterController {
	
	private final RouterService routerService;
	
	
	@Autowired
	public RouterController(RouterService routerService) {
		super();
		this.routerService = routerService;
	}
	
//	@PostMapping(value = "/customers")
//	public List<Routers> heel() {
//
//		return (List<Routers>) routerService.getall();
//		
//		
//	}
	
	
	
//	@PostMapping(value = "/pcustomers")
//	public Routers placerouter(@RequestBody RouterRequest request) {
//		return routerService.placedevice(request);
//	}
	
	
	@PostMapping(value = "/gcustomers")
	public List<Routers> getrouter() {
		return routerService.getdevice();
	}
	
	
	@PostMapping(value = "/getdevices")
	public List<Devices> devices(@RequestBody int accountNumber){
		
		return routerService.getrouterdevices(accountNumber);	
	}
	
	@PostMapping(value = "/adddevice")
	public ResponseEntity<String> adddevice(@RequestBody RouterLogin router) {		
		return routerService.adddevice(router);
	}
	
	
	
	
	
	
	

}
