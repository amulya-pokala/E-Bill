package com.leap.hackathon.elist.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.leap.hackathon.elist.models.Bill;

public class BillMapper implements RowMapper<Bill> {

	@Override
	public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bill bill = new Bill();
		bill.setBillJson(rs.getString("bill_data"));
		bill.setCustomerId(rs.getInt("customer_id"));
		bill.setVendorId(rs.getInt("vendor_id"));
		bill.setDateOfPurchase(rs.getDate("date"));
		return bill;
	}

}
