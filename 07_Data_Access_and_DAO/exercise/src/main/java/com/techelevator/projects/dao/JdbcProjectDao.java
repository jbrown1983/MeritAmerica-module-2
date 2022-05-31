package com.techelevator.projects.dao;

import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sql = "Select project_id, name, from_date, to_date " +
				"FROM project " +
				"WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		if (results.next()) {
			project = mapRowToProject(results);
		}


		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "Select project_id, name, from_date, to_date " +
				"FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {

			Project project = mapRowToProject(results);

			projects.add(project);

		}

		return projects;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date)" +
				" VALUES (?, ?, ?) RETURNING project_id;";
		Long newId = jdbcTemplate.queryForObject(sql,
				Long.class,
				newProject.getName(),
				newProject.getFromDate(),
				newProject.getToDate());
		Project project = getProject(newId);
		return project;
	}

	@Override
	public void deleteProject(Long projectId) {
		String sqlDeleteProjectEmployee  =
				" DELETE FROM project_employee"+
						" WHERE project_id = ?;";

		String sqlDeleteTimeSheet =
				" DELETE FROM timesheet"+
						" WHERE project_id = ?;";

		String sqlDelete = "DELETE FROM project" +
				" WHERE project_id = ?;";

		jdbcTemplate.update(sqlDeleteProjectEmployee, projectId);
		jdbcTemplate.update(sqlDeleteTimeSheet, projectId);
		jdbcTemplate.update(sqlDelete, projectId);

	}

	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		if (rowSet.getDate("from_date") != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if(rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}


}
