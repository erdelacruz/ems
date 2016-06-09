package com.ems.employee.domain.type;

public enum MobileType {
	MOBILE,PHONE;
	
	public static MobileType getMobileType(String type){
		if("Mobile".equalsIgnoreCase(type)){
			return MOBILE;
		}else if("Phone".equalsIgnoreCase(type)){
			return PHONE;
		}
		return MOBILE;
	}
}
