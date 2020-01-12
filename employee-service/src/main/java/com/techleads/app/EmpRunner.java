package com.techleads.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Employee;
import com.techleads.app.service.EmployeeService;
@Component
public class EmpRunner implements CommandLineRunner {
	@Autowired
	private  EmployeeService service;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = service.getEmpById(1);
		System.out.println("done");
		System.out.println(employee);
	}

}
