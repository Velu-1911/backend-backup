package com.example.major.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "plans")
public class Plans {
	
	@Id
	@SequenceGenerator(
			name="plan_sequence",
			sequenceName = "plan_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "plan_sequence"
	)
	private Long planID;
	
	
	private String planName;
	
	private String speed;
	
	private String dataLimit;
	
	private int price;
	
	
	@JsonBackReference("customers-plans")
	@ManyToOne
	@JoinColumn(name = "customer_accountNumber")
	private Customers customer;
	
	
	@JsonManagedReference("plans-routers")
	@OneToOne(mappedBy = "plans", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Routers router;
	
	
	
	@JsonManagedReference
	@OneToOne(mappedBy = "plans", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Bills bills;
	
	
	public Plans()
	{
		
	}

	public Plans(Long planID, String planName, String speed, String dataLimit, int price, Customers customer) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
		this.customer = customer;
	}

	public Plans(Long planID, String planName, String speed, String dataLimit, int price) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
	}

	public Plans(String planName, String speed, String dataLimit, int price) {
		super();
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
	}
	
	
	public Plans(Long planID, String planName, String speed, String dataLimit, int price, Customers customer,
			Routers router) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
		this.customer = customer;
		this.router = router;
	}
	
	public Plans(Long planID, String planName, String speed, String dataLimit, int price, Customers customer,
			Routers router, Bills bills) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.speed = speed;
		this.dataLimit = dataLimit;
		this.price = price;
		this.customer = customer;
		this.router = router;
		this.bills = bills;
	}
	

	public Long getPlanID() {
		return planID;
	}

	public void setPlanID(Long planID) {
		this.planID = planID;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDataLimit() {
		return dataLimit;
	}

	public void setDataLimit(String dataLimit) {
		this.dataLimit = dataLimit;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	

	public Routers getRouter() {
		return router;
	}

	public void setRouter(Routers router) {
		this.router = router;
	}
		
	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	
	@Override
	public String toString() {
		return "Plans [planID=" + planID + ", planName=" + planName + ", speed=" + speed + ", dataLimit=" + dataLimit
				+ ", price=" + price + ", router=" + router + ", bills=" + bills + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
