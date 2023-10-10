package com.example.major.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
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
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_accountNumber")
	private Customers customer;
	
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

	@Override
	public String toString() {
		return "Plans [planID=" + planID + ", planName=" + planName + ", speed=" + speed + ", dataLimit=" + dataLimit
				+ ", price=" + price + ", customer=" + customer + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
