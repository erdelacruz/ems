package com.ems.employee.domain.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ems.commons.exception.EntityNotFoundException;
import com.ems.employee.domain.dto.EmployeeDTO;
import com.ems.employee.domain.dto.RoleDTO;
import com.ems.employee.domain.entity.AddressEntity;
import com.ems.employee.domain.entity.ContactEntity;
import com.ems.employee.domain.entity.EmployeeEntity;
import com.ems.employee.domain.entity.RoleEntity;
import com.ems.employee.domain.type.GenderType;
import com.ems.employee.domain.type.MobileType;
import com.ems.employee.service.RoleService;

@Component
public class RoleDataTransferUtility {
	
	
	public RoleEntity getRoleEntityFromDataTransfer(RoleDTO dto){
		
		RoleEntity entity = new RoleEntity();
		entity.setId(dto.getId());
		entity.setRoleName(dto.getRoleName());
		
		return entity;
	}
	
	
	public RoleDTO getDataTransferFromRoleEntity(RoleEntity entity){
		
		RoleDTO dto = new RoleDTO();
		dto.setId(entity.getId());
		dto.setRoleName(entity.getRoleName());
		
		return dto;
	}
	
	public List<RoleDTO> getDataTransferFromListOfRoleEntity(List<RoleEntity> listOfRoleEntity){
		List<RoleDTO> listOfDataTransfer = new ArrayList<RoleDTO>();
		for(RoleEntity entity:listOfRoleEntity){
			listOfDataTransfer.add(getDataTransferFromRoleEntity(entity));
		}
		return listOfDataTransfer;
	}
	
	
	
	
	
}
