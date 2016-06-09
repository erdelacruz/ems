package com.ems.user.domain.type;

public enum UserType {
	ADMIN("Admin"),USER("User");
	private String userType;
	
	UserType(String userType){
		this.userType = userType;
	}
	
	static UserType getUserType(String type){
		if(type.equalsIgnoreCase("ADMIN")){
			return ADMIN;
		}else if(type.equalsIgnoreCase("USER")){
			return USER;
		}
		return USER;
	}
}
