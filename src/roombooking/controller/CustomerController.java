package roombooking.controller;

import roombooking.container.CustomerContainer;
import roombooking.model.Customer;

public class CustomerController {

	public Customer findCustomerByEmail(String email) {
		return CustomerContainer.getInstance().findCustomerByEmail(email);
	}
}