package com.ems.employee.domain.dto;

import java.io.Serializable;


public class SearchEmployeeDTO implements Serializable {
	
	
	
	private String firstname;
	
	private String lastname;
	
	private String middlename;
	
	private Long roleId;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
	
	
}
