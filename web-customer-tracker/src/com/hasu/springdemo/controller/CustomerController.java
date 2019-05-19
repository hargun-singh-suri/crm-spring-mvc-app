package com.hasu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hasu.springdemo.entity.Customer;
import com.hasu.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		// Get customers from service
		List<Customer> customerList = customerService.getCustomers();

		// Add customers from service to model
		model.addAttribute("customers", customerList);

		return "listCustomer";
	}
}
