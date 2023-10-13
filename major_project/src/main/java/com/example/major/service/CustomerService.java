package com.example.major.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.major.dto.RouterDetails;
import com.example.major.entity.Customers;
import com.example.major.entity.Plans;
import com.example.major.entity.users;
import com.example.major.repository.CustomerRepository;
import com.example.major.repository.DeviceRepository;
import com.example.major.repository.PlanRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PlanRepository planRepository;

//	@Autowired
//	public CustomerService(CustomerRepository customerRepository) {
//		this.customerRepository = customerRepository;
//	}

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
		System.out.println(customer.getAccountNumber());
		 Optional<Customers> acctcheck = customerRepository.findCustomerByaccountNum(customer.getAccountNumber());
		 Customers c = new Customers();
		 if(acctcheck.isPresent()) {
			  c = acctcheck.get();
		 }
		

		 Customers cust = new Customers();

		 cust.setEmail(c.getEmail());

		 cust.setphonenumber(c.getphonenumber());

		 cust.setName(c.getName());

		 //cust.setphonenumber(c.getphonenumber());

		 System.out.print(cust);

		 return cust;

	}

	public List<Plans> getplans(Customers customer) {
		// TODO Auto-generated method stub
		Optional<Customers> ifexists = customerRepository.findCustomerByEmail(customer.getEmail());
		Optional<Customers> ifexistsphone = customerRepository.findCustomerByPhone(customer.getEmail());
		if(ifexists.isPresent()) {
			Customers existing = ifexists.get();
			System.out.println("hello");
			return (List<Plans>) existing.getPlans();
		}
		else if(ifexistsphone.isPresent()) {
			Customers existing = ifexistsphone.get();
			System.out.println("hello");
			return (List<Plans>) existing.getPlans();	
		}
		return null;
	}


	public Object getRouterDetails(Customers customer) {
			Optional<Customers> cust = customerRepository.findCustomerByEmail(customer.getEmail()) ;
			List<RouterDetails> sendRouters=  new ArrayList();
			if(cust.isPresent()) {
				Customers existing = cust.get();
				System.out.println("Customer exists");
				List<Plans> planlist = existing.getPlans(); 
				if(planlist.isEmpty()) {
					return null;
				}
				
				for(int i=0;i<planlist.size();i++) {
//					if(planlist.get(i).getRouter() == null) {
//						System.out.println("router not exists");					
//					}
//					else {
//						System.out.println("router exists");
//					}
					
					if(Objects.isNull(planlist.get(i).getRouter())) {
						System.out.println("this gets skipped");
					}
					else {
						RouterDetails router = new RouterDetails();
						
						router.setPlanID(planlist.get(i).getPlanID());
						router.setPlanName(planlist.get(i).getPlanName());
						router.setRouterID(planlist.get(i).getRouter().getRouterID());
						router.setSerialNumber(planlist.get(i).getRouter().getSerialNumber());
						router.setModel(planlist.get(i).getRouter().getModel());
						router.setFirmwareVersion(planlist.get(i).getRouter().getFirmwareVersion());
						router.setSsid(planlist.get(i).getRouter().getSsid());
						router.setPassword(planlist.get(i).getRouter().getPassword());
						
						
						sendRouters.add(router);
					}
					
				}
			}
			
			return sendRouters;
		}
	

}
	

