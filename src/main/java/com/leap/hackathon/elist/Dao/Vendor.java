package com.leap.hackathon.elist.Dao;

import com.leap.hackathon.elist.models.Item;

public interface Vendor {
	public boolean createVendor(Vendor vendor);
	public boolean addItems(Item item);
}
