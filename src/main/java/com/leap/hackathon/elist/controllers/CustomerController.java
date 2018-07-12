package com.leap.hackathon.elist.controllers;

import java.net.UnknownHostException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.leap.hackathon.elist.CustomExceptions.CustomBadRequestException;
import com.leap.hackathon.elist.Dao.CustomerDao;
import com.leap.hackathon.elist.models.Bill;
import com.leap.hackathon.elist.models.Customer;

public class CustomerController {
	@Autowired
	CustomerDao customerDAO;

	@PostMapping(value = "/e-list/api/customer")
	public void addNewCustomer(@RequestBody @Valid Customer customer, BindingResult bindingResult,
			HttpServletRequest request) throws UnknownHostException {
		System.out.println("customer data"+customer.getAlias());
		if (bindingResult.hasErrors()) {
			throw new CustomBadRequestException("Invalid details.\n");
		}
		boolean isDone = customerDAO.createCustomer(customer);
		if (!isDone) {
			throw new CustomBadRequestException("Admin already exist with same Admin Name");
		}

	}

	@GetMapping(value = "/api/getBills/{customerId}")
	public List<Bill> getAllCustomerBills(@PathVariable int customerId, BindingResult bindingResult,
			HttpServletRequest request) throws UnknownHostException {
		if (bindingResult.hasErrors()) {
			throw new CustomBadRequestException("Invalid details.\n");
		}
		List<Bill> bills = customerDAO.getCustomerBills(customerId);
		return bills;
	}

	@GetMapping(value = "/api/getBills/filter/{month}/{year}/{customerId}")
	public List<Bill> filterBillsByMonth(@PathVariable String month, @PathVariable String year,
			@PathVariable int customerId, BindingResult bindingResult, HttpServletRequest request)
			throws UnknownHostException {
		if (bindingResult.hasErrors()) {
			throw new CustomBadRequestException("Invalid details.\n");
		}
		List<Bill> bills = customerDAO.FilterByMonth(customerId, month, year);
		return bills;
	}

	@GetMapping(value = "/api/customer/login/{name}/{password}")
	public int loginCustomer(@PathVariable String name, @PathVariable String password, BindingResult bindingResult,
			HttpServletRequest request) throws UnknownHostException {
		return customerDAO.validateCustomer(name, password);

	}

}
