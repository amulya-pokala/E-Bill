package com.leap.hackathon.elist.models;

public class Vendor {
	private String storeName;
	private String branchName;
	private String vendorName;
	private String password;
	private String emailId;
	private String phoneNo;
	private int vendorId;
	
	public Vendor(String storeName, String branchName, String vendorName, String password, String emailId,
			String phoneNo) {
		super();
		this.storeName = storeName;
		this.branchName = branchName;
		this.vendorName = vendorName;
		this.password = password;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
}
