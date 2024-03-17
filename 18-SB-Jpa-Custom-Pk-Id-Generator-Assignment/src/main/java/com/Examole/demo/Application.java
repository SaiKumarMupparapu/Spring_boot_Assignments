package com.Examole.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Examole.demo.Service.CustomerService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		CustomerService customerService = run.getBean(CustomerService.class);
		customerService.saveCustomer("ram");

		customerService.getAllCustomers();

	}

}
