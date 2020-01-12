package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = {"com.techleads"})
public class EmployeeServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(EmployeeServiceApplication.class, args);
		
	}

}
