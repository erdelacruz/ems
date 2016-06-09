package com.ems.employee.controller.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ems.employee.domain.dto.SearchEmployeeDTO;
@Component
public class SearchEmployeeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return SearchEmployeeDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		SearchEmployeeDTO form = (SearchEmployeeDTO) object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstname", "firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastname", "lastname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"middlename", "middlename.empty");
		
		if(form.getRoleId()==null){
			errors.rejectValue("roleId","role.empty");
		}
		
	}

}
