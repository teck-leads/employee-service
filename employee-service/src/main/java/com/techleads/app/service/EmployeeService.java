package com.techleads.app.service;

import java.util.List;

import com.techleads.app.model.Employee;

public interface EmployeeService {

	public Employee getEmpById(Integer id) throws Exception;
	public List<Employee> getEmps() throws Exception;
	public int saveEmploye(Employee emp) throws Exception;
	public int deleteEmploye(Integer id) throws Exception;
}
