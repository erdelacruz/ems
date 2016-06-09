package com.ems.employee.controller.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ems.employee.domain.dto.EmployeeDTO;
@Component
public class CreateAndUpdateEmployeeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return EmployeeDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		EmployeeDTO form = (EmployeeDTO) object;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstname", "firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastname", "lastname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"middlename", "middlename.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"generalWeightedAverageAsString", "gwa.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"gender", "gender.empty");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"street", "street.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"city", "city.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"barangay", "barangay.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"zipCode", "zipCode.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"houseNumber", "houseNumber.empty");
		
		if(form.getRolesId()==null||form.getRolesId().size()==0){
			errors.rejectValue("rolesId","role.empty");
		}
		
		if(!containsOnlyNumbers(form.getGeneralWeightedAverageAsString())){
			errors.rejectValue("generalWeightedAverageAsString","gwa.empty");
		}
		
		if(form.getEmployed()==null){
			errors.rejectValue("employed","employed.empty");
		}
		
		if(form.getBirthDate()==null){
			errors.rejectValue("birthDate","birthDate.empty");
		}
	}
	
	
	 private boolean containsOnlyNumbers(String str) {
		    for (int i = 0; i < str.length(); i++) {
		      if(str.charAt(i)=='.') continue;
		      if (!Character.isDigit(str.charAt(i))) return false;
		    }
		    return true;
		  }

}
