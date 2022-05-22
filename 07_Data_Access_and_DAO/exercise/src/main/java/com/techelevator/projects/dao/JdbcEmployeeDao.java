package com.techelevator.projects.dao;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	// Gets all employees from the datastore and returns them in a List
	public List<Employee> getAllEmployees() {
		String sqlGetAllEmployees = "SELECT employee_id, first_name, last_name FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(getAllEmployess);

		while (results.next()){
			getAllEmployees.add(employee.mapRowToEmployee(results));
		}

		return getAllEmployees;
	}

	//List<Department> departmentList = new ArrayList<>();
	//
	//		String sqlGetALLDepartments = "SELECT department_id,name FROM department;";
	//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetALLDepartments);
	//
	//		while (results.next()){
	//			departmentList.add(department.mapRowToDepartment(results));
	//		}
	//		return departmentList;
	//	}



	@Override
	// Find all employees whose names contain the search strings. Returned employees should
	//	 * match both first and last name search strings. If a search string is blank,
	//	 * ignore it. If both strings are blank, return all employees.
	//	 * Be sure to use ILIKE for case-insensitive search matching!
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		return List.of(new Employee());
	}

	@Override
	// Get all of the employees that are on the project with the given id.
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		return new ArrayList<>();
	}

	@Override
	// Assign an employee to a project
	public void addEmployeeToProject(Long projectId, Long employeeId) {
	}

	@Override
	//Unassign the employee from a project. Assign an employee to a project
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
	}

	@Override
	//* Get all of the employees that aren't assigned to any project.
	//	 * @return all the employees not on a project as Employee objects in a List
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}


}
