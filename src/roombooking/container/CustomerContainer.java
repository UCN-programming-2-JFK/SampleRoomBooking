package roombooking.container;

import java.util.ArrayList;
import java.util.List;

import roombooking.model.Customer;

public class CustomerContainer {
	private static CustomerContainer instance;
	private CustomerContainer() {}
	public static CustomerContainer getInstance() {
		if(instance==null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	private List<Customer> customers = new ArrayList<Customer>();
	
	public Customer findCustomerByEmail (String email) {
	
		Customer foundCustomer = null;
		
		for(Customer customer: customers) {
			if(customer.getEmail().equals(email)) {
				foundCustomer = customer;
			}
		}
		
		return foundCustomer;
	}
	
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
}
