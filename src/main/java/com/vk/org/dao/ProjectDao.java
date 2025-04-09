
package com.vk.org.dao;

import java.util.List;

import com.vk.org.entities.Project;


public interface ProjectDao {

	
	public List<Project> getAllProjects();

	public Project getProjectById(int pId);
	
	public List<Project> findByProjectId(Integer projectid);
	
	public List<Project> findByTitle(String title);

}
