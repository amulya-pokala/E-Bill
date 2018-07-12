package com.leap.hackathon.elist.controllers;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.leap.hackathon.elist.CustomExceptions.CustomBadRequestException;
import com.leap.hackathon.elist.Dao.VendorDao;
import com.leap.hackathon.elist.models.Bill;
import com.leap.hackathon.elist.models.Item;
import com.leap.hackathon.elist.models.Vendor;

public class VendorController {
	@Autowired
	VendorDao vendorDAO;

	@PostMapping(value = "/api/vendor")
	public void addNewVendor(@RequestBody @Valid Vendor vendor, BindingResult bindingResult, HttpServletRequest request)
			throws UnknownHostException {

		if (bindingResult.hasErrors()) {
			throw new CustomBadRequestException("Invalid details.\n");
		}
		boolean isDone = vendorDAO.createVendor(vendor);
		if (!isDone) {
			throw new CustomBadRequestException("Vendor already exist with same Vendor Name");
		}
	}

	@PostMapping(value = "/api/vendor/add/{vendorId}")
	public void addNewItemForVendor(@PathVariable int vendorId, @RequestBody @Valid Item item,
			BindingResult bindingResult, HttpServletRequest request) throws UnknownHostException {
		if (bindingResult.hasErrors()) {
			throw new CustomBadRequestException("Invalid details.\n");
		}
		boolean isDone = vendorDAO.addItems(item, vendorId);
		if (!isDone) {
			throw new CustomBadRequestException("Vendor already exist with same Vendor Name");
		}

	}

	@PostMapping(value = "api/vendor/postBill")
	public void postBill(Bill bill, BindingResult bindingResult, HttpServletRequest request)
			throws UnknownHostException {
		vendorDAO.Purchase(bill.getBillJson(), bill.getCustomerId(), bill.getVendorId());

	}

}
