package com.Examole.demo.Service;

import org.springframework.stereotype.Service;

import com.Examole.demo.Entity.Customer;
import com.Examole.demo.Repo.CustomerRepo;

@Service
public class CustomerService {

	private CustomerRepo cr;

	public CustomerService(CustomerRepo cr) {
		this.cr = cr;
	}

	public void saveCustomer(String name) {
		Customer c = new Customer();
		c.setName(name);
		cr.save(c);
	}

	public void getAllCustomers() {
		cr.findAll().forEach(System.out::println);

	}

}
