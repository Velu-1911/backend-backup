package com.example.major.dto;

import java.time.LocalDate;

public class BillPayment {
	
	private Long planID;
	
	private String planName;

	private LocalDate dueDate;

	private LocalDate paymentDate;
	
	private Long amount;
	
	private String billStatus;

	public BillPayment() {
		
	}
	
	public BillPayment(Long planID, String planName, LocalDate dueDate, LocalDate paymentDate, Long amount) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	


	public BillPayment(Long planID, String planName, LocalDate dueDate, LocalDate paymentDate, Long amount,
			String billStatus) {
		super();
		this.planID = planID;
		this.planName = planName;
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.billStatus = billStatus;
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


	public Long getAmount() {
		return amount;
	}


	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	public String getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}

	@Override
	public String toString() {
		return "BillPayment [planID=" + planID + ", planName=" + planName + ", dueDate=" + dueDate + ", paymentDate="
				+ paymentDate + ", amount=" + amount + ", billStatus=" + billStatus + "]";
	}
	
	
	
	
	
	
	
	
}
