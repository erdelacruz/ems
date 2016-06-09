package com.ems.user.domain.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.ems.user.domain.type.UserType;
@Entity
@Table(name="USER_TABLE")
public class UserEntity implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private UserType type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	
	
	
	
	
	
}
