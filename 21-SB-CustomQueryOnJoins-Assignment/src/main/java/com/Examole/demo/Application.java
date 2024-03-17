package com.Examole.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Examole.demo.Service.EmpAdrsService;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = 
				SpringApplication.run(Application.class, args);
	
		EmpAdrsService empAdrsService =
				context.getBean(EmpAdrsService.class);
	
		empAdrsService.saveEmpWithAdrs();
		empAdrsService.getEmpAlongWithAddrs();
	}

}
