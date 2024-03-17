package com.Examole.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Examole.demo.Service.EmpService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run =
				SpringApplication.run(Application.class, args);
		EmpService empSerObj = run.getBean(EmpService.class);
		
		empSerObj.insertEmp();
		empSerObj.getEmp();
	
	}

}
