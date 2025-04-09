package com.vk.org.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Role {

	@Id
	private int role_id;
	
	private String role;
	
	public int getRole_id() {
		return role_id;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	} 
	
	
}
