package com.example.major.configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.major.entity.Address;
import com.example.major.entity.Bills;
import com.example.major.entity.Customers;
import com.example.major.entity.Devices;
import com.example.major.entity.Plans;
import com.example.major.entity.Routers;
import com.example.major.entity.paymentHistory;
import com.example.major.repository.AdressRepository;
import com.example.major.repository.BillRepository;
import com.example.major.repository.CustomerRepository;
import com.example.major.repository.DeviceRepository;
import com.example.major.repository.PlanRepository;
import com.example.major.repository.RouterRepository;
import com.example.major.repository.paymentHistoryRepository;

@Configuration
public class CustomersConfiguration {
	
	
	@Bean
	CommandLineRunner commandLineRunner33(CustomerRepository customerRepository,PlanRepository planRepository,
				RouterRepository routerRepository,DeviceRepository deviceRepository, BillRepository billRepository,paymentHistoryRepository historyrepository, AdressRepository addresRepository) {
		return args->{
			
		/*procedure to add a customer
		 * 1.Create a Customer
		 * 2. add plans and add it to the plan list of customer
		 * 3.Create one bill and one router for the customer(router is optional)
		 * 4.Add devices if the router exists and also set the router and device mapping.
		 * 
		 * */
		
			
			Address ambattur = new Address("ambattur");
			Address thirumulaivayol = new Address("thirumulaivayol");
			Address kovilambakkam = new Address("kovilambakkam");
			
			List<Routers> ambatturlist = new ArrayList();
			List<Routers> thirumulaivayolList = new ArrayList();
			List<Routers> kovilambakkamList = new ArrayList();
			
			
		////////////////////THESE VALUES ARE FOR PRESENTING////////////////////////////////////////////	
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
						"60GB",
						500
					);
			plan1.setCustomer(velu);
			
			paymentHistory payment1 = new paymentHistory(500l
					,"UPI",
					LocalDate.of(2023,Month.JULY,25),
					"Basic",
					LocalDate.of(2023,Month.JUNE,25)
					,1l
					);
			
			
			
			paymentHistory payment2 = new paymentHistory(516l
					,"UPI"
					,LocalDate.of(2023,Month.AUGUST,24),
					"Basic",
					LocalDate.of(2023,Month.JULY,25),
					1l
					);
			
			paymentHistory payment3 = new paymentHistory(500l
					,"UPI",
					LocalDate.of(2023,Month.SEPTEMBER,23),
					"Basic"
					,LocalDate.of(2023,Month.AUGUST,24),
					1l
					);
			
			paymentHistory payment4 = new paymentHistory(500l
					,"UPI",
					LocalDate.of(2023,Month.OCTOBER,24),
					"Basic"
					,LocalDate.of(2023,Month.SEPTEMBER,24),
					1l
					);
			
			
			List<paymentHistory> paymentvelu = new ArrayList();
			paymentvelu.add(payment1);
			paymentvelu.add(payment2);
			paymentvelu.add(payment3);
			paymentvelu.add(payment4);
			velu.setPayments(paymentvelu);
			payment1.setCustomerhistory(velu);
			payment2.setCustomerhistory(velu);
			payment3.setCustomerhistory(velu);
			payment4.setCustomerhistory(velu);

			
			//////////////////////////////////////////////////
			
			Bills plan1bill  = new Bills(
					LocalDate.of(2023,Month.OCTOBER,13),
					LocalDate.of(2023, Month.SEPTEMBER,13)
					);
			
			plan1bill.setPlans(plan1);
			plan1.setBills(plan1bill);
			
			List<Plans> Velulist = new ArrayList();
			Velulist.add(plan1);
			velu.setPlans(Velulist);
			
			
			
			

			Routers veluRouter = new Routers();
			veluRouter.setAccountNumber(1);
			veluRouter.setSerialNumber("22034F5000400");
			veluRouter.setModel("TP_link");
			veluRouter.setFirmwareVersion("V1.0.0");
			veluRouter.setIpv4("192.168.1.0");
			veluRouter.setSsid("Batman's Cave");
			veluRouter.setPassword("hellorouter");
			veluRouter.setAddress(ambattur);
			veluRouter.setPlans(plan1);
			plan1.setRouter(veluRouter);
			
			ambatturlist.add(veluRouter);
			ambattur.setRouter(ambatturlist);

			
			
			
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
			
			
			
			Devices device4trial = new Devices();
			device4trial.setDeviceId("4");
			device4trial.setDeviceType("Android");
			device4trial.setMac("Mom phone");
			device4trial.setIsBlocked(false);
			device4trial.setRouter(veluRouter);
			
			Devices device5trial = new Devices();
			device5trial.setDeviceId("5");
			device5trial.setDeviceType("Android");
			device5trial.setMac("dad phone");
			device5trial.setIsBlocked(false);
			device5trial.setRouter(veluRouter);
			
			
			
			List<Devices> veluDevice = new ArrayList();
			//veluDevice.add((Devices) List.of(device1,device2,device3));
			veluDevice.add(device1);
			veluDevice.add(device2);
			veluDevice.add(device3);
			veluDevice.add(device4trial);
			veluDevice.add(device5trial);
			
			
			
			veluRouter.setDevices(veluDevice);
			
//////////////////////////customer velu ends here//////////////////////////
			
			
			Customers guru = new Customers(
					"guru",
					"f-7 gr flats",
					"guru@gmail.com",
					"+919344062366",
					2										
					);
			
			
			
			List<Plans> GuruList = new ArrayList();
			
			Plans plan6 = new Plans("Premium",
					"150",
					"250GB",
					"90GB",
					800
				);
			plan6.setCustomer(guru);
			
			
			
			
			
			paymentHistory payment2_1 = new paymentHistory(433l
					,"UPI"
					,LocalDate.now()
					,"Basic"
					,LocalDate.now()
					,1l
					);
			List<paymentHistory> paymentguru = new ArrayList();
			paymentguru.add(payment2_1);
			guru.setPayments(paymentguru);
			payment2_1.setCustomerhistory(guru);
			
			Bills plan6bill  = new Bills(
					LocalDate.of(2023,Month.OCTOBER,30),
					LocalDate.of(2023, Month.SEPTEMBER,30)
					);

			plan6bill.setPlans(plan6);
			plan6.setBills(plan6bill);
			
			
			GuruList.add(plan6);
			guru.setPlans(GuruList);
			
			
			
			/*
			 
			  
			  Plans plan1 = new Plans("Basic",
						"100",
						"100GB",
						"60GB",
						500
					);
			plan1.setCustomer(velu);
			
			paymentHistory payment1 = new paymentHistory(433l
					,"UPI"
					,LocalDate.now()
					,LocalDate.now()
					,1l
					);
			
			
			List<paymentHistory> paymentvelu = new ArrayList();
			paymentvelu.add(payment1);
			velu.setPayments(paymentvelu);
			payment1.setCustomerhistory(velu);

			
			//////////////////////////////////////////////////
			
			Bills plan1bill  = new Bills(
					LocalDate.of(2023,Month.OCTOBER,22),
					LocalDate.of(2023, Month.SEPTEMBER,22)
					);
			
			plan1bill.setPlans(plan1);
			plan1.setBills(plan1bill);
			
			List<Plans> Velulist = new ArrayList();
			Velulist.add(plan1);
			velu.setPlans(Velulist);
			  
			  
			 */
			
			

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
			guruRouter.setAddress(thirumulaivayol);
			plan6.setRouter(guruRouter);
			
			thirumulaivayolList.add(guruRouter);
			
			thirumulaivayol.setRouter(thirumulaivayolList);

			
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
			

			
	/////////////////////////////////guru ends here////////////////////////////////////////////////////		
			
			
			Customers isu = new Customers(
					"iswarya",
					"f-7 gr flats",
					"isu@gmail.com",
					"+918428984718",
					3										
					);
			
			Plans planisu = new Plans("Basic",
					"100",
					"100GB",
					"30GB",
					500
				);
			planisu.setCustomer(isu);
			
			paymentHistory paymentisu1 = new paymentHistory(500l
					,"Card",
					LocalDate.of(2023,Month.OCTOBER,23),
					"Basic",
					LocalDate.of(2023,Month.SEPTEMBER,23)
					,3l
					);
			
			
		
			
			List<paymentHistory> paymentisu = new ArrayList();
			paymentisu.add(paymentisu1);
			isu.setPayments(paymentguru);
			payment2_1.setCustomerhistory(guru);
			
			Bills planISUbill  = new Bills(
					LocalDate.of(2023,Month.OCTOBER,23),
					LocalDate.of(2023, Month.SEPTEMBER,23)
					);

			
			List<Plans> isuList = new ArrayList();
						
						isuList.add(planisu);
						
						isu.setPlans(isuList);
			
			
			


			Routers isuRouter = new Routers();
			isuRouter.setAccountNumber(3);
			isuRouter.setSerialNumber("22034F5000500");
			isuRouter.setModel("TP_link");
			isuRouter.setFirmwareVersion("V1.0.0");
			isuRouter.setIpv4("192.168.1.0");
			isuRouter.setSsid("Isu home");
			isuRouter.setPassword("hellorouter");
			isuRouter.setAddress(kovilambakkam);
			isuRouter.setPlans(planisu);
			planisu.setRouter(isuRouter);
			
			
			kovilambakkamList.add(isuRouter);
			kovilambakkam.setRouter(ambatturlist);

			
			
			
			
			
			
			
			
			
			
/////////////////////////    THESE VALUES ARE FOR PRESENTATION  ////////////////////////////////////////////////////////////////			
		
			
			customerRepository.saveAll(List.of(velu,guru,isu));
			
			
//			Customers temp = plan1.getCustomer();
//			System.out.println(temp);
			
			
			
			
//			Plans plan2 = new Plans("Premium",
//					"130",
//					"120GB",
//					"10GB",
//					700
//				);
//			plan2.setCustomer(velu);
//			
//			Plans plan3 = new Plans("Basic",
//					"140",
//					"120GB",
//					"80GB",
//					500
//				);
//			plan3.setCustomer(velu);
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
			
			
			
			
			//Velulist.add(plan2);
			//Velulist.add(plan3);
			
			
//			Velulist.add(plan4);
//			Velulist.add(plan5);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//			
//			Routers veluRouter2 = new Routers();
//			veluRouter2.setAccountNumber(1);
//			veluRouter2.setSerialNumber("22034F5000440");
//			veluRouter2.setModel("TP_link");
//			veluRouter2.setFirmwareVersion("V1.1.0");
//			veluRouter2.setIpv4("127.0.30.196");
//			veluRouter2.setSsid("Batman's Cave2");
//			veluRouter2.setPassword("hellorouter");
//			
//			veluRouter2.setPlans(plan3);
//			plan3.setRouter(veluRouter2);
//			
			
			

			
			
		
			
			

			
			
			
//			
//			
//			Plans plan7 = new Plans("Basic",
//					"140",
//					"120",
//					500
//				);
//			plan7.setCustomer(guru);
//			
//			//			GuruList.add(plan7);

		
//			
//			
//			
//			
////		GuruList.add(plan3);
////		GuruList.add(plan4);
////		GuruList.add(plan5);
//
//			
			
			
			
			
			//customerRepository.save(velu);
			
			///////////////////////////////////////////////////////////////////////////////////
			
			
			
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
