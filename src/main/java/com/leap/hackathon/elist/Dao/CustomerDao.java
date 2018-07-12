package com.leap.hackathon.elist.Dao;

import java.util.List;

import com.leap.hackathon.elist.models.Bill;
import com.leap.hackathon.elist.models.Customer;

public interface CustomerDao {
	
	public boolean createCustomer(Customer customer);
	public boolean deleteCustomer(long customerId);
	public List<Bill> getCustomerBills(long customerId);
	

}
