package com.vk.org.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vk.org.entities.Project;
import java.lang.Integer;
import java.util.List;
import java.lang.String;

@RepositoryRestResource(collectionResourceRel = "project", path = "project")
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	
	List<Project> findByProjectId(Integer projectid);
	
	List<Project> findByTitle(String title);
	

}
