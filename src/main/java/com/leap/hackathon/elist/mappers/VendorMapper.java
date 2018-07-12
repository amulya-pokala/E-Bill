package com.leap.hackathon.elist.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.leap.hackathon.elist.models.Vendor;

public class VendorMapper implements RowMapper<Vendor> {
	@Override
	public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vendor vendor=new Vendor();
		vendor.setBranchName(rs.getString("branch"));
		vendor.setStoreName(rs.getString("store_name"));
		return vendor;
	}
}
