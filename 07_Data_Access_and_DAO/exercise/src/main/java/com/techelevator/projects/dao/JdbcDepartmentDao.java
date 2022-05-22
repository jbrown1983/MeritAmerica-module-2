package com.techelevator.projects.dao;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcDepartmentDao implements DepartmentDao  {
	
	private final JdbcTemplate jdbcTemplate;
	private Department department;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long id) {
		Department department = null;
		String sqlGetDepartment = "SELECT department_id,name FROM department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetDepartment, id);

		if(results.next()){
			department = department.mapRowToDepartment(results);
		}

	return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departmentList = new ArrayList<>();

		String sqlGetALLDepartments = "SELECT department_id,name FROM department;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetALLDepartments);

		while (results.next()){
			departmentList.add(department.mapRowToDepartment(results));
		}
		return departmentList;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
	String updateDepartment = "UPDATE department SET name=? WHERE department_id=?";
	jdbcTemplate.update(updateDepartment, updatedDepartment.getName(), updatedDepartment.getId());

	}

}
