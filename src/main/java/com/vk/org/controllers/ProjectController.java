package com.vk.org.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import com.vk.org.entities.Project;
import com.vk.org.exception.IdNotFoundException;
import com.vk.org.exception.ABCOrgException;
import com.vk.org.services.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {


	@Autowired
	private ProjectService projectService;

	@RequestMapping(method = RequestMethod.GET, value = "/projects", produces="application/json")
	public ResponseEntity<Object> getAllProjects() throws ABCOrgException {

		List<Project> lstProjects = projectService.getAllProjects();

		if (lstProjects.isEmpty()) {
			throw new ABCOrgException("There is no list of Projects.");
		}

		return new ResponseEntity<>(lstProjects, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/projects/{id}", produces="application/json")
	public ResponseEntity<Object> getProjectById(@PathVariable("id") int pId) throws IdNotFoundException, HttpMessageNotWritableException, MethodArgumentTypeMismatchException {

		try {
			if (projectService.findByProjectId(pId).size()>0) {
				Project prj = projectService.getProjectById(pId);
				return new ResponseEntity<>(prj, HttpStatus.OK);
			} else {
					throw new IdNotFoundException(pId);	
			}
			
		} catch (HttpMessageNotWritableException e) {
			throw new HttpMessageNotWritableException(e.getMessage());
		}
		catch (MethodArgumentTypeMismatchException e) {
			throw new MethodArgumentTypeMismatchException(e.getValue(), e.getRequiredType(), e.getName(), e.getParameter(), e.getCause());
		}
//		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
