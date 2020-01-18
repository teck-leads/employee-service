package com.techleads.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.techleads.app.commons.DBQueries;
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
			jdbcTemplate.query(DBQueries.GET_EMP_BY_ID, new ResultSetExtractor<Employee>() {

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

	@Override
	public List<Employee> getEmps() throws Exception {
		List<Employee> emps = new ArrayList<Employee>();
		jdbcTemplate.query(DBQueries.GET_EMPS, new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setId(rs.getInt("ID"));
					emp.setName(rs.getString("NAME"));
					emp.setSalary(rs.getDouble("SALARY"));
					emps.add(emp);
				}
				return emps;
			}
		});
		return emps;
	}

	@Override
	public int saveEmployee(Employee emp) throws Exception {
		try {
			Object[] obj = { emp.getId(), emp.getName(), emp.getSalary() };
			int updateCount = jdbcTemplate.update(DBQueries.INSERT_EMP, obj);

			return updateCount;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int deleteEmploye(Integer id) throws Exception {
		try {
			Object[] obj = { id };
			int deletecount = jdbcTemplate.update(DBQueries.DEL_EMP_BY_ID, obj);
			return deletecount;
		} catch (Exception e) {
			throw e;
		}
	}
}
