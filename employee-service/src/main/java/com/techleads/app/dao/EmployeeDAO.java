package com.techleads.app.dao;

import java.util.List;

import com.techleads.app.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmpById(Integer id) throws Exception;
	public int saveEmployee(Employee emp) throws Exception;
	public List<Employee> getEmps() throws Exception;
	public int deleteEmploye(Integer id) throws Exception;

}
