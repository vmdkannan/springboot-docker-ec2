package com.vk.org.services;

import java.util.List;

import com.vk.org.entities.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	Project getProjectById(int pId);

	public List<Project> findByProjectId(Integer projectid);
	
	public List<Project> findByTitle(String title);

}
