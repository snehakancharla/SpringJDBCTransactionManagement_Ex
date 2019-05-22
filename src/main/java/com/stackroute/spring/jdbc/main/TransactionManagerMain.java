package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Address;
import com.stackroute.spring.jdbc.service.CustomerManagerImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stackroute.spring.jdbc.model.Customer;
import com.stackroute.spring.jdbc.service.CustomerManager;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		CustomerManager customerManager = ctx.getBean("customerManager",
				CustomerManagerImpl.class);

		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(3);
		customer.setName("Rutu");
		Address address = new Address();
		address.setId(3);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Kormangala");
		customer.setAddress(address);
		return customer;
	}

}
