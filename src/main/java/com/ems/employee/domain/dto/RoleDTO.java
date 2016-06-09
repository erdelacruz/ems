package com.ems.employee.domain.dto;

import java.io.Serializable;

import javax.persistence.*;

import com.ems.employee.domain.type.MobileType;

public class RoleDTO implements Serializable {
	
	private Long id;
	private String roleName;
	
	private Boolean selected = Boolean.FALSE;
	
	
	
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
