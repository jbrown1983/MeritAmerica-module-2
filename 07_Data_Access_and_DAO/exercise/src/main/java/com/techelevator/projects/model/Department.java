package com.techelevator.projects.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Department {

	private Long id;
	private String name;

	public Department() {}

	public Department(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.name;
	}

	 public Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();

		department.setId(results.getLong("department_id"));
		department.setName(results.getString("name"));

		return department;
	}
}
