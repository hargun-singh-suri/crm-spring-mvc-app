package com.hasu.springdemo.service;

import java.util.List;

import com.hasu.springdemo.entity.Customer;

public interface CustomerService {
	//Implementing service facade pattern
	public List<Customer> getCustomers();
}
