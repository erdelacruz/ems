package com.ems.employee.domain.type;

public enum GenderType {
	MALE,FEMALE;
	
	
	public static GenderType getGenderType(String gender){
		if("Male".equalsIgnoreCase(gender)){
			return MALE;
		}else if("Female".equalsIgnoreCase(gender)){
			return FEMALE;
		}
		return MALE;
	}
}
