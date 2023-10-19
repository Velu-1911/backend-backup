package com.example.major.dto;

import java.util.Random;

import lombok.Data;


public class RouterLogin {
	
	private String randomdevice() {
		
		String[] arr={"Android","Iphone","Laptop"};
		Random r=new Random(); 
        int randomNumber=r.nextInt(arr.length); 
        String type = arr[randomNumber];
        
		return type;	

	}
	
	
	
	private String ssid;
	
	private String password;
	
	
	private String mac;
	
	private String deviceType = randomdevice();
	
	
	public RouterLogin() {
		
	}

	public RouterLogin(String ssid, String password, String mac, String deviceType) {
		super();
		this.ssid = ssid;
		this.password = password;
		this.mac = mac;
		this.deviceType = deviceType;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	@Override
	public String toString() {
		return "RouterLogin [ssid=" + ssid + ", password=" + password + ", mac=" + mac + ", deviceType=" + deviceType
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
