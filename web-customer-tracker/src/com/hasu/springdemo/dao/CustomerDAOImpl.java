package com.hasu.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

	public List<Customer> getCustomers() {
		// # Get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// # Create Query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name", Customer.class);

		// # Get result from query by executing it
		List<Customer> customerList = theQuery.getResultList();

		// # Return the results
		return customerList;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// # Get hibernate session
		Session session = sessionFactory.getCurrentSession();

		// Save the customer
		// If pk exist then update else if pk do not exist then insert
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomerById(int theId) {
		// # Get hibernate session
		Session session = sessionFactory.getCurrentSession();

		// Get the Customer from DB using the ID
		Customer theCustomer = session.get(Customer.class, theId);

		// Return the instance of the customer
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// # Get hibernate session
		Session session = sessionFactory.getCurrentSession();

		//Delete the user using pk
		Query query = session.createQuery("delete from Customer where id=:theCustomerId");
		query.setParameter("theCustomerId", theId);
		query.executeUpdate();
		

	}

}
