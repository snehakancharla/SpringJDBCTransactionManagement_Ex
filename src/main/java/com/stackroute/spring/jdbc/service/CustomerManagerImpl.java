package com.stackroute.spring.jdbc.service;

import org.springframework.transaction.annotation.Transactional;

import com.stackroute.spring.jdbc.dao.CustomerDAO;
import com.stackroute.spring.jdbc.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}

}
