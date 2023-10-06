package com.example.major.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Customers {
	
	
	@Id
	@SequenceGenerator(
			name="customer_sequence",
			sequenceName = "customer_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "customer_sequence"
	)
	private Long customer_num;
	
	private String name;
	
	private String address;
	
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String Phonenumber;
	
	@Column(unique=true)
	private int accountNumber;
	
	public Customers() {
		
	}

	public Customers(String name, String address, String email, String phonenumber, int accountNumber) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.Phonenumber = phonenumber;
		this.accountNumber = accountNumber;
	}

	public Customers(Long customer_num, String name, String address, String email, String phonenumber,
			int accountNumber) {
		super();
		this.customer_num = customer_num;
		this.name = name;
		this.address = address;
		this.email = email;
		Phonenumber = phonenumber;
		this.accountNumber = accountNumber;
	}

	public Long getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(Long customer_num) {
		this.customer_num = customer_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return Phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Customers [customer_num=" + customer_num + ", name=" + name + ", address=" + address + ", email="
				+ email + ", Phonenumber=" + Phonenumber + ", accountNumber=" + accountNumber + "]";
	}
	
	
	
	
	
	
	
	
	

}
