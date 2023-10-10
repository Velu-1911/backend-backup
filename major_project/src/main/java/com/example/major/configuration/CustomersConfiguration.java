package com.example.major.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.major.entity.Customers;
import com.example.major.entity.Plans;
import com.example.major.repository.CustomerRepository;
import com.example.major.repository.PlanRepository;

@Configuration
public class CustomersConfiguration {
	
	
	@Bean
	CommandLineRunner commandLineRunner33(CustomerRepository customerRepository,PlanRepository planRepository ) {
		return args->{
			Customers velu = new Customers(
					"velu",
					"f-7 gr flats",
					"velu@gmail.com",
					"+911111111111",
					1
										
					);
			
			Plans plan1 = new Plans("Basic",
						"100",
						"100",
						50
					);
			plan1.setCustomer(velu);
			
			
			Plans plan2 = new Plans("PRemium",
					"130",
					"120",
					57
				);
			plan2.setCustomer(velu);
			
			Plans plan3 = new Plans("Basic",
					"140",
					"120",
					60
				);
			plan3.setCustomer(velu);
			
			
			Plans plan4 = new Plans("Basic",
					"140",
					"120",
					60
				);
			plan4.setCustomer(velu);
			
			
			Plans plan5 = new Plans("Basic",
					"140",
					"120",
					60
				);
			plan5.setCustomer(velu);
			
			
			
			List<Plans> Velulist = new ArrayList();
			Velulist.add(plan1);
			Velulist.add(plan2);
			Velulist.add(plan3);
			Velulist.add(plan4);
			Velulist.add(plan5);
			
			
			velu.setPlans(Velulist);
			
			
			
			Customers guru = new Customers(
					"guru",
					"f-7 gr flats",
					"guru@gmail.com",
					"+911234567890",
					2										
					);
			
			
			
			List<Plans> GuruList = new ArrayList();
			
			Plans plan6 = new Plans("Basic",
					"140",
					"120",
					60
				);
			plan6.setCustomer(guru);
			
			
			Plans plan7 = new Plans("Basic",
					"140",
					"120",
					60
				);
			plan7.setCustomer(guru);
			
			
			
			
			GuruList.add(plan6);
			GuruList.add(plan7);
			guru.setPlans(GuruList);
			
//			GuruList.add(plan3);
//			GuruList.add(plan4);
//			GuruList.add(plan5);
			
			
			
			
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
