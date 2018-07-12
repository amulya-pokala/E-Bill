package com.leap.hackathon.elist.Dao;

import javax.sql.DataSource;

import com.leap.hackathon.elist.models.Item;
import com.leap.hackathon.elist.models.Vendor;

public interface VendorDao {
	public boolean createVendor(Vendor vendor);
	public boolean addItems(Item item,int vendorId);
	public void setDataSource(DataSource dataSource);
	public boolean Purchase(String bill, int customerId, int vendorId);
}
