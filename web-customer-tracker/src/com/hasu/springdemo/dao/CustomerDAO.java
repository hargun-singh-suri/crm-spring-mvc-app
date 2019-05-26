package com.hasu.springdemo.dao;

import java.util.List;
import com.hasu.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(int theId);

	public void deleteCustomer(int theId);

}
