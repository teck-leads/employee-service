package com.techleads.app;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techleads.app.model.Employee;
import com.techleads.app.service.EmployeeService;
@Component
public class EmpRunner implements CommandLineRunner {
	@Autowired
	private  EmployeeService service;
	@Autowired
	private DataSource dataSource;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dataSource.getClass().getName());
		Employee emp =new Employee();
		emp.setId(2);
		emp.setName("Teja");
		emp.setSalary(50000D);
		int saveCount = service.saveEmploye(emp);
		System.out.println("SaveCount "+saveCount);
		List<Employee> emps = service.getEmps();
		System.out.println("Get all employee details ");
		emps.forEach(e->{
			System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
		});
		Employee emp1 = service.getEmpById(1);
		System.out.println("Emp get by ID ");
		System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getSalary());
		System.out.println("delete emp by Id");
		Integer id=1;
		int deleteCount = service.deleteEmploye(id);
		System.out.println("deleted Emp Id "+id);
	}

}
