package com.techleads.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.techleads.app.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee getEmpById(Integer id) throws Exception {
		Employee emp = new Employee();
		try {
			Object[] objs= {id};
			jdbcTemplate.query("SELECT ID, NAME, SALARY FROM EMP WHERE ID=?", new ResultSetExtractor<Employee>() {

				@Override
				public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
					while (rs.next()) {
						emp.setId(rs.getInt("ID"));
						emp.setName(rs.getString("NAME"));
						emp.setSalary(rs.getDouble("SALARY"));
					}
					return emp;
				}
			},objs);
		} catch (Exception e) {
			throw e;
		}
		return emp;
	}
}
