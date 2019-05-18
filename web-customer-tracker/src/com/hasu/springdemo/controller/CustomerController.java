package com.hasu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hasu.springdemo.entity.Customer;

import com.hasu.springdemo.dao.CustomerDAO;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	// Need to inject Customer DAO
	@Autowired
	private CustomerDAO customerDao;

	@RequestMapping("/listCustomers")
	public String listCustomers(Model model) {

		// Get customers from DAO
		List<Customer> customerList = customerDao.getCustomers();

		// Add customers from DAO to model
		model.addAttribute("customers", customerList);

		return "listCustomer";
	}
}
