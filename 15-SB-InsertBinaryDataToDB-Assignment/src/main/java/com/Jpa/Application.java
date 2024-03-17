package com.Jpa;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Jpa.Service.PersonService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext contxt =
				SpringApplication.run(Application.class, args);
		PersonService pSerObj = contxt.getBean(PersonService.class);
		pSerObj.savePerson();

	}

	

}
