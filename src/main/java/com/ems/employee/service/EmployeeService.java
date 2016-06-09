package com.ems.employee.service;

import java.util.List;

import com.ems.commons.service.GenericService;
import com.ems.employee.domain.dto.EmployeeDTO;
import com.ems.employee.domain.dto.SearchEmployeeDTO;

public interface EmployeeService extends GenericService<EmployeeDTO,Long> {
	
	public List<EmployeeDTO> getEmployeeBy(SearchEmployeeDTO searchQuery);
}
