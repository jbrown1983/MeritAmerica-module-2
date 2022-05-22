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
	// * Get a project from the datastore that has the given id. * If the id is not found, return null.
	//	* @param projectId the id of the project to get from the datastore *@return a filled out project object
	public Long getProject(Long projectId) {
		Project project = null;
		String sql = "SELECT project_id;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(String.valueOf(projectId));
		if (results.next()) {
			project = project.mapRowToProject(results);
		}
		return projectId;
	}

	@Override
	//Get a list of all projects.
	public List<Project> getAllProjects() {
		List<Project> projectList = new ArrayList<>();
		String sql = "SELECT project_id, name FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		while (results.next()){
			projectList.add(projectList(results));
		}
		return projectList;
	}


	@Override
	//Inserts a new project into the datastore.
	public Long createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date,to_date) VALUSE (?,?,?,) RETURNING project_id;";
		Long newId = jdbcTemplate.queryForObject(sql, Long.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		return getProject(newId);
	}

	@Override
	public void deleteProject(Long projectId) {
	String deleteProjectSql = "DELETE FROM project WHERE project_id = ?;";
	int numberOfRowsDeleted = jdbcTemplate.update(deleteProjectSql, projectId.getProjectId());

		deleteProjectSql = "DELETE FROM project WHERE project_id = ?;";
	numberOfRowsDeleted = jdbcTemplate.update(deleteProjectSql, projectId.getProjectIId());
		if (numberOfRowsDeleted == 1) {
			System.out.println("Project was deleted");
		}
		else {
			System.out.println("Project delete failed.");
	}
	

}
}
