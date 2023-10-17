package com.example.major.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Bills {
	
	@Id
	@SequenceGenerator(
			name="bill_sequence",
			sequenceName = "bill_sequence",
			allocationSize=1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "bill_sequence"
	)
	private Long billID;
	
	private LocalDate dueDate;
	
	private LocalDate paymentDate;

	
	private int amount;
	
	
	@JsonBackReference
	@OneToOne
    @MapsId
    @JoinColumn(name = "plan_id")
	private Plans plans;
	
	public Bills() {
		
	}
	

	public Bills(Long billID, LocalDate dueDate, LocalDate paymentDate, int amount, Plans plans) {
		super();
		this.billID = billID;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.plans = plans;
	}

	
	




	public Bills(LocalDate dueDate, LocalDate paymentDate, int amount) {
		super();
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}


	public Long getBillID() {
		return billID;
	}


	public void setBillID(Long billID) {
		this.billID = billID;
	}


	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}


	public LocalDate getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Plans getPlans() {
		return plans;
	}


	public void setPlans(Plans plans) {
		this.plans = plans;
	}


	@Override
	public String toString() {
		return "Bills [billID=" + billID + ", dueDate=" + dueDate + ", paymentDate=" + paymentDate + ", amount="
				+ amount + "]";
	}


	
	
	
	
	
	
	

	
	
	
}
