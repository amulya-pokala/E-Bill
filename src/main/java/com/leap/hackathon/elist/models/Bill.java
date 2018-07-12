package com.leap.hackathon.elist.models;

import java.sql.Date;

public class Bill {
	private String billJson;
	private long vendorId;
	private long customerId;
	private Date dateOfPurchase;
	public String getBillJson() {
		return billJson;
	}
	public void setBillJson(String billJson) {
		this.billJson = billJson;
	}
	public long getVendorId() {
		return vendorId;
	}
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

}
