package com.techleads.app.dao;

import com.techleads.app.model.Employee;

public interface EmployeeDAO {
	
	public Employee getEmpById(Integer id) throws Exception;

}
