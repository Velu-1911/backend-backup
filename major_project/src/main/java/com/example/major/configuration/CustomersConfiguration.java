package com.example.major.configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.major.entity.Bills;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Plans;
import com.example.major.entity.Routers;
import com.example.major.repository.BillRepository;
import com.example.major.repository.CustomerRepository;
import com.example.major.repository.DeviceRepository;
import com.example.major.repository.PlanRepository;
import com.example.major.repository.RouterRepository;

@Configuration
public class CustomersConfiguration {
	
	
	@Bean
	CommandLineRunner commandLineRunner33(CustomerRepository customerRepository,PlanRepository planRepository,RouterRepository routerRepository,DeviceRepository deviceRepository, BillRepository billRepository) {
		return args->{
			Customers velu = new Customers(
					"Pethachi PR",
					"f-7 gr flats",
					"velu@gmail.com",
					"+919789876704",
					1					
					);
			
			Plans plan1 = new Plans("Basic",
						"100",
						"100GB",
						"120.5GB",
						500
					);
			plan1.setCustomer(velu);
			
			
			
			//////////////////////////////////////////////////
			
			Bills plan1bill  = new Bills(
					LocalDate.of(2023,Month.NOVEMBER,9),
					LocalDate.of(2023, Month.OCTOBER, 10),
					500
					
					);
			
			plan1bill.setPlans(plan1);
			plan1.setBills(plan1bill);
			
			Plans plan2 = new Plans("PRemium",
					"130",
					"120GB",
					"10GB",
					700
				);
			plan2.setCustomer(velu);
			
			Plans plan3 = new Plans("Basic",
					"140",
					"120GB",
					"80GB",
					500
				);
			plan3.setCustomer(velu);
//			
//			
//			Plans plan4 = new Plans("Basic",
//					"140",
//					"120",
//					60
//				);
//			plan4.setCustomer(velu);
//			
//			
//			Plans plan5 = new Plans("Basic",
//					"140",
//					"120",
//					60
//				);
//			plan5.setCustomer(velu);
			
			
			
			List<Plans> Velulist = new ArrayList();
			Velulist.add(plan1);
			Velulist.add(plan2);
			Velulist.add(plan3);
			
			
//			Velulist.add(plan4);
//			Velulist.add(plan5);
			
			
			velu.setPlans(Velulist);
			
			
			
			
			
			
			
			
			
			
			
			Routers veluRouter = new Routers();
			veluRouter.setAccountNumber(1);
			veluRouter.setSerialNumber("22034F5000400");
			veluRouter.setModel("TP_link");
			veluRouter.setFirmwareVersion("V1.0.0");
			veluRouter.setIpv4("127.0.30.146");
			veluRouter.setSsid("Batman's Cave");
			veluRouter.setPassword("hellorouter");
			
			veluRouter.setPlans(plan1);
			plan1.setRouter(veluRouter);
			
			
			
			
			
			
			
			Routers veluRouter2 = new Routers();
			veluRouter2.setAccountNumber(1);
			veluRouter2.setSerialNumber("22034F5000440");
			veluRouter2.setModel("TP_link");
			veluRouter2.setFirmwareVersion("V1.1.0");
			veluRouter2.setIpv4("127.0.30.196");
			veluRouter2.setSsid("Batman's Cave2");
			veluRouter2.setPassword("hellorouter");
			
			veluRouter2.setPlans(plan3);
			plan3.setRouter(veluRouter2);
			
			
			
			Devices device1 = new Devices();
			device1.setDeviceId("1");
			device1.setDeviceType("Android");
			device1.setMac("velu's phone");
			device1.setIsBlocked(false);
			device1.setRouter(veluRouter);
			
			
			Devices device2 = new Devices();
			device2.setDeviceId("2");
			device2.setDeviceType("Android");
			device2.setMac("guru's phone");
			device2.setIsBlocked(true);
			device2.setRouter(veluRouter);
			
			
			Devices device3 = new Devices();
			device3.setDeviceId("3");
			device3.setDeviceType("Android");
			device3.setMac("naveen's phone");
			device3.setIsBlocked(false);
			device3.setRouter(veluRouter);
			
			List<Devices> veluDevice = new ArrayList();
			//veluDevice.add((Devices) List.of(device1,device2,device3));
			veluDevice.add(device1);
			veluDevice.add(device2);
			veluDevice.add(device3);
			
			veluRouter.setDevices(veluDevice);

			
			
			Customers guru = new Customers(
					"guru",
					"f-7 gr flats",
					"guru@gmail.com",
					"+919344062366",
					2										
					);
			
			
			
			List<Plans> GuruList = new ArrayList();
			
			Plans plan6 = new Plans("Basic",
					"140",
					"120GB",
					"100GB",
					500
				);
			plan6.setCustomer(guru);
//			
//			
//			Plans plan7 = new Plans("Basic",
//					"140",
//					"120",
//					500
//				);
//			plan7.setCustomer(guru);
//			
//						
			GuruList.add(plan6);
//			GuruList.add(plan7);
			guru.setPlans(GuruList);
//			
//			
			Routers guruRouter = new Routers(
			2,
			"22034F5000410",
			"TP_link",
			"V1.0.0",
			"127.0.30.146",
			"Superman's Cave",
			"hellorouter"		
			);
			guruRouter.setPlans(plan6);
			plan6.setRouter(guruRouter);
	
			Devices device4 = new Devices();
			device4.setDeviceId("1");
			device4.setDeviceType("Android");
			device4.setMac("naveen's phone");
			device4.setIsBlocked(true);
			device4.setRouter(guruRouter);
			
			
			Devices device5 = new Devices();
			device5.setDeviceId("2");
			device5.setDeviceType("Android");
			device5.setMac("guru's phone");
			device5.setIsBlocked(true);
			device5.setRouter(guruRouter);
			
			List<Devices> guruDevice = new ArrayList();
			guruDevice.add(device4);
			guruDevice.add(device5);
			guruRouter.setDevices(guruDevice);
//			
//			
////		GuruList.add(plan3);
////		GuruList.add(plan4);
////		GuruList.add(plan5);
//
//			
			Customers isu = new Customers(
					"iswarya",
					"f-7 gr flats",
					"isu@gmail.com",
					"+918428984718",
					3										
					);
			
			
			
			customerRepository.saveAll(List.of(velu,guru,isu));
			//customerRepository.save(velu);
			
			///////////////////////////////////////////////////////////////////////////////////
			
			Customers temp = plan1.getCustomer();
			System.out.println(temp);
			
			/*This is a testing cde to get all the details we want and load them into the customer object*/
			
//			Customers temp = new Customers();
//			temp.setAddress(plan1.getCustomer().getAddress());
//			temp.setEmail(plan1.getCustomer().getEmail());
//			temp.setName(plan1.getCustomer().getName());
//			temp.setphonenumber(plan1.getCustomer().getphonenumber());
//			System.out.println(temp);
			
			//System.out.println(velu.getPlans().get(0).getRouter().getSsid());
			
		};
	}

}
