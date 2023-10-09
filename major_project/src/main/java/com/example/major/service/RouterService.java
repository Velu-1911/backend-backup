package com.example.major.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.major.dto.RouterLogin;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Routers;
import com.example.major.repository.DeviceRepository;
import com.example.major.repository.RouterRepository;

@Service
public class RouterService {
	
	@Autowired
	private RouterRepository routerRepository;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
//	@Autowired
//	public RouterService(RouterRepository routerRepository) {
//		super();
//		this.routerRepository = routerRepository;
//		this.deviceRepository = null;
//	}
	
	


//	public RouterService(DeviceRepository deviceRepository) {
//		super();
//		this.routerRepository = null;
//		this.deviceRepository = deviceRepository;
//	}


	public List<Routers> getall() {
		// TODO Auto-generated method stub
		return routerRepository.findAll();
	}

	
//	public Routers placedevice(@RequestBody RouterRequest request) {
//		return routerRepository.save(request.getRouter());
//	}
	
	
	public List<Routers> getdevice() {
		return routerRepository.findAll();
	}


	public List<Devices> getrouterdevices(int accountNumber) {
		Optional <Routers> getdevice = routerRepository.findbyaccount(accountNumber);
		if(getdevice.isPresent()) {
			Routers exists = getdevice.get();
			return exists.getDevices(); 
		}
		
		
		return null;
	}


	public ResponseEntity<String> adddevice(RouterLogin router) {
		Optional<Routers> getdevice = routerRepository.findbyssid(router.getSsid());
		if(getdevice.isPresent()) {
			Routers exists = getdevice.get();
			//return (ResponseEntity<String>) ResponseEntity.ok("Login ");
			if(exists.getPassword().equals(router.getPassword())) {
				//first we set the paramaters for the device//
				Devices add_devicee = new Devices();
				add_devicee.setDeviceType(router.getDeviceType());
				
				add_devicee.setMac(router.getMac());
				add_devicee.setIsBlocked(false);
				add_devicee.setRouter(exists);
				//exists.getDevices().add(add_devicee);
				List<Devices> routerDevices= exists.getDevices(); 
//				if(routerDevices.contains(add_devicee.getMac())) {
//					System.out.println("hello");
//				}
				
				Boolean existing = false;
				Devices existing_device=new Devices();
				
				
				for (int i = 0; i < routerDevices.size(); i++) {
					 
		            if(routerDevices.get(i).getMac().equals(router.getMac())){
		            	existing_device = routerDevices.get(i); 
		            	existing =true;
//		            	System.out.println(existing_device.getIsBlocked());
//		            	System.out.println("MAC exists");
//						return (ResponseEntity<String>) ResponseEntity.ok("You are already connected");

		            }
				}
				
				if(existing) {
					if(existing_device.getIsBlocked() == true) {
						return (ResponseEntity<String>) ResponseEntity.ok("You have been blocked");
					}
					else {
						return (ResponseEntity<String>) ResponseEntity.ok("You are already connected");
					}
				}
				
				
				//Optional<Devices> macexists = deviceRepository.findbymac(router.getMac());
				int size = routerDevices.size();
				size+=1;
				System.out.println(size);
				if(size==11) {			
					return (ResponseEntity<String>) ResponseEntity.ok("Sorry you have already added 10 devices please remove one");
				}
				String deviceid = Integer.toString(size); 
				add_devicee.setDeviceId(deviceid);
				
				//System.out.println(routerDevices.size());
				routerDevices.add(add_devicee);
				//System.out.println(routerDevices.size());
				deviceRepository.save(add_devicee);
				System.out.println("Object ADDED");
				return (ResponseEntity<String>) ResponseEntity.ok("Object Added");
//				
				
			}
			else {
				return (ResponseEntity<String>) ResponseEntity.ok("Wrong password ");
			}
		}	
		
		
		
		return (ResponseEntity<String>) ResponseEntity.ok("ssid not found");
	}
	
	


	
	
	

	

}
