package com.techleads.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techleads.app.dao.EmployeeDAO;
import com.techleads.app.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public Employee getEmpById(Integer id) throws Exception {
		try {
			Employee emp = employeeDAO.getEmpById(id);
			return emp;
		} catch (Exception e) {
			throw e;
		}
	}
}
