package com.Examole.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.Examole.demo.Service.EmpService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmpService empService = context.getBean(EmpService.class);
//		empService.dataToExcel();
		empService.dataToPdf();
	}

}
