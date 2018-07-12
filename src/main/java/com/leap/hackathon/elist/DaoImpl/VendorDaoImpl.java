package com.leap.hackathon.elist.DaoImpl;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.leap.hackathon.elist.Dao.VendorDao;
import com.leap.hackathon.elist.models.Item;
import com.leap.hackathon.elist.models.Vendor;
import com.leap.hackathon.elist.utility.Query;



public class VendorDaoImpl implements VendorDao{
	private JdbcTemplate jdbcTemplate;
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);
	public boolean createVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		try {
		
			jdbcTemplate.update(Query.CREATEVENDOR, vendor.getVendorName(), vendor.getPassword(), vendor.getEmailId(),vendor.getPhoneNo(),vendor.getStoreName());
			int vendorId = jdbcTemplate.queryForObject(Query.GETCUSTOMERID, new Object[] { vendor.getEmailId() },
					Integer.class);
			vendor.setVendorId(vendorId);
			jdbcTemplate.update(Query.CREATEVENDORTABLE);
		} catch (DataAccessException e) {
			logger.info("couldn't insert customer" + vendor.getVendorName());
			return false;
		}
		return true;
	}

	public boolean addItems(Item item) {
		// TODO Auto-generated method stub
		try {
			
		}
		
		return false;
	}

}
