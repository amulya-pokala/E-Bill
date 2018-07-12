package com.leap.hackathon.elist.Dao;

import com.leap.hackathon.elist.models.Item;
import com.leap.hackathon.elist.models.Vendor;

public interface VendorDao {
	public boolean createVendor(Vendor vendor);
	public boolean addItems(Item item);
}
