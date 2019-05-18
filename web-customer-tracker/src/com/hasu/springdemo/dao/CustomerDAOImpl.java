package com.hasu.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.hasu.springdemo.entity.Customer;

/*@Repository will help in component scanning and translate checked exception to unchecked*/
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	/*
	 * DAO will require Session Factory Session Factory will require DataSource
	 * Session Factory and DataSource are linked together in xml via dependency
	 * injectio
	 */

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Customer> getCustomers() {
		// # Get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// # Create Query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		// # Get result from query by executing it

		List<Customer> customerList = theQuery.getResultList();

		// # Return the results
		return customerList;
	}

}
