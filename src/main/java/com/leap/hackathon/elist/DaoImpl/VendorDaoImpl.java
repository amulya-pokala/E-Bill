package com.leap.hackathon.elist.DaoImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.leap.hackathon.elist.Dao.VendorDao;
import com.leap.hackathon.elist.mappers.VendorMapper;
import com.leap.hackathon.elist.models.Item;
import com.leap.hackathon.elist.models.Vendor;
import com.leap.hackathon.elist.utility.Query;

public class VendorDaoImpl implements VendorDao {
	private JdbcTemplate jdbcTemplate;
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	public boolean createVendor(Vendor vendor) {

		try {

			jdbcTemplate.update(Query.CREATEVENDOR, vendor.getVendorName(), vendor.getPassword(), vendor.getEmailId(),
					vendor.getPhoneNo(), vendor.getStoreName());
			jdbcTemplate.update(Query.CREATEVENDORTABLE, vendor.getVendorName() + "_" + vendor.getBranchName());
		} catch (DataAccessException e) {
			logger.info("couldn't insert vendor" + vendor.getVendorName());
			return false;
		}
		return true;
	}

	@Override
	public boolean Purchase(String bill, long customerId, long vendorId) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		int billId = jdbcTemplate.queryForObject(Query.GETBILLID, new Object[] { bill }, Integer.class);
		jdbcTemplate.update(Query.CREATEBILL, new Object[] { customerId, billId, bill, vendorId, dtf.format(now) });
		return true;
	}

	@Override
	public boolean addItems(Item item, int vendorId) {
		try {
			Vendor vendor=jdbcTemplate.queryForObject(Query.GETVENDORBYID,new Object[] {vendorId}, new VendorMapper());
			jdbcTemplate.update(Query.ADDITEM, vendor.getStoreName()+"_"+vendor.getBranchName(),item.getItemName(), item.getPrice(), item.isAvailable() ? 1 : 0);
		} catch (DataAccessException e) {
			logger.info("couldn't insert item");
			return false;
		}
		return true;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int validateVendor(String vendorName, String password) {
		Integer vendorId;
		try {
			vendorId = jdbcTemplate.queryForObject(Query.AUTHENTICATEVENDOR, new Object[] { vendorName, password }, Integer.class);
		} catch (Exception e) {
			vendorId = null;
		}
		return vendorId;
	}

}
