package com.leap.hackathon.elist.DaoImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

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
		
		try {
		
			jdbcTemplate.update(Query.CREATEVENDOR, vendor.getVendorName(), vendor.getPassword(), vendor.getEmailId(),vendor.getPhoneNo(),vendor.getStoreName());
			int vendorId = jdbcTemplate.queryForObject(Query.GETCUSTOMERID, new Object[] { vendor.getEmailId() },
					Integer.class);
			vendor.setVendorId(vendorId);
			jdbcTemplate.update(Query.CREATEVENDORTABLE,vendor.getVendorName()+""+vendor.getBranchName());
		} catch (DataAccessException e) {
			logger.info("couldn't insert customer" + vendor.getVendorName());
			return false;
		}
		return true;
	}

	

	public boolean Purchase(String bill, int customerId, int vendorId) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now();
		   int billId = jdbcTemplate.queryForObject(Query.GETBILLID, new Object[] { bill },
					Integer.class);
		   jdbcTemplate.update(Query.CREATEBILL,new Object[] {customerId,billId,bill,vendorId,dtf.format(now)});
		return true;
	}
	@Override
	public boolean addItems(Item item, int vendorId) {
		try {
			jdbcTemplate.update(Query.ADDITEM,item.getItemName(),item.getPrice(),item.isAvailable()?1:0);
		}catch (DataAccessException e) {
			logger.info("couldn't insert item");
			return false;
		}
		return true;
	}
	@Override
	public void setDataSource(DataSource dataSource) {
		 jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

}
