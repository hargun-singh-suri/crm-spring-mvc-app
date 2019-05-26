package com.hasu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/showFormForAdd")
	public String showFormForAddCustomer(Model theModel) {
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		// Save the customer using the service
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {

		// Get the Customer from Service
		Customer theCustomer = customerService.getCustomerById(theId);

		// Set customer as Model Attribute to prepopulate on to the Update Form
		theModel.addAttribute("customer", theCustomer);

		// Send the model data to the form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId){
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
