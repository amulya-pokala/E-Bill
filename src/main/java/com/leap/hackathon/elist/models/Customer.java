package com.leap.hackathon.elist.models;

public class Customer {

	private int customerId;
	private String name;
	private String mailId;
	private String alias;
	private String password;
	private String phoneNo;
	
	public Customer(String name, String mailId, String alias, String phoneNo,String password) {
		super();
		this.name = name;
		this.mailId = mailId;
		this.alias = alias;
		this.phoneNo = phoneNo;
		this.password=password;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
