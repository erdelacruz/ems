package com.ems.employee.domain.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.ems.employee.domain.type.MobileType;
@Entity
@Table(name="ROLE_TABLE")
public class RoleEntity implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="role_id")
	private Long id;
	private String roleName;
	
	
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
