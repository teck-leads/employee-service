package com.techleads.app.service;

import java.util.List;

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

	@Override
	public int saveEmploye(Employee emp) throws Exception {
		try {
			int saveCount = employeeDAO.saveEmployee(emp);
			return saveCount;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Employee> getEmps() throws Exception {
		try {
			List<Employee> emps = employeeDAO.getEmps();
			return emps;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int deleteEmploye(Integer id) throws Exception {
		try {
			int deleteCount = employeeDAO.deleteEmploye(id);
			return deleteCount;
		} catch (Exception e) {
		throw e;
		}
	}
}
