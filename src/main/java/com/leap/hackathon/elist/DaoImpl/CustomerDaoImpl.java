package com.leap.hackathon.elist.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


import com.leap.hackathon.elist.Dao.CustomerDao;
import com.leap.hackathon.elist.mappers.BillMapper;

import com.leap.hackathon.elist.models.Bill;
import com.leap.hackathon.elist.models.Customer;
import com.leap.hackathon.elist.models.Item;
import com.leap.hackathon.elist.utility.Query;

public class CustomerDaoImpl implements CustomerDao{

	private JdbcTemplate jdbcTemplate;
	private static final Logger logger = Logger.getLogger(CustomerDaoImpl.class);
	@Override
	public boolean createCustomer(Customer customer) {
		try {
			jdbcTemplate.update(Query.CREATECUSTOMER, customer.getName(), customer.getPassword(), customer.getMailId(),customer.getPhoneNo(),customer.getAlias());
			int customerId = jdbcTemplate.queryForObject(Query.GETCUSTOMERID, new Object[] { customer.getMailId() },
					Integer.class);
			customer.setCustomerId(customerId);;
		} catch (DataAccessException e) {
			logger.info("couldn't insert customer" + customer.getName());
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteCustomer(long customerId) {
		try {
			jdbcTemplate.update(Query.DELETECUSTOMER,customerId);
			
		} catch (DataAccessException e) {
			logger.info("cant delete customer" + customerId);
			return false;
		}
		return false;
	}

	@Override
	public List<Bill> getCustomerBills(long customerId) {
			return jdbcTemplate.query(Query.GETALLCUSTOMERBILLS, new Object[] { customerId },new BillMapper());
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		 jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

}
