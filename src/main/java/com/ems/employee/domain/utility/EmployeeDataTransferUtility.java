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
public class EmployeeDataTransferUtility {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleDataTransferUtility roleDataTransferUtilitity;
	
	public EmployeeEntity getEmployeeEntityFromDataTransfer(EmployeeDTO dto){
		
		EmployeeEntity employee = new EmployeeEntity();
		employee.setId(dto.getId());
		employee.setFirstname(dto.getFirstname());
		
		employee.setLastname(dto.getLastname());
		employee.setMiddlename(dto.getMiddlename());
		employee.setGender(GenderType.getGenderType(dto.getGender()));
		employee.setBirthDate(dto.getBirthDate());
		employee.setEmployed(dto.getEmployed());
		employee.setGeneralWeightedAverage(dto.getGeneralWeightedAverage());
		
		AddressEntity address = new AddressEntity();
		address.setBarangay(dto.getBarangay());
		address.setCity(dto.getCity());
		address.setHouseNumber(dto.getHouseNumber());
		address.setStreet(dto.getStreet());
		address.setSubdivision(dto.getSubdivision());
		address.setZipCode(dto.getZipCode());
		employee.setAddress(address);
		
		ContactEntity contact = new ContactEntity();
		contact.setType(MobileType.getMobileType(dto.getContactType()));
		contact.setContactNumber(dto.getContactNumber());
		employee.setContact(contact);
		
		RoleEntity role = null;
		Set<RoleEntity> roles = new HashSet<RoleEntity>();
		
		for(long roleId:dto.getRolesId()){
			try {
				if(roleId!=0){
					role = roleDataTransferUtilitity.getRoleEntityFromDataTransfer(roleService.getById(roleId));
					roles.add(role);
					
				}
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		employee.setRoles(roles);
		
		return employee;
	}
	
	
	
	public EmployeeDTO getDataTransferFromEmployeeEntity(EmployeeEntity entity){
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(entity.getId());
		dto.setFirstname(entity.getFirstname());
		dto.setLastname(entity.getLastname());
		dto.setMiddlename(entity.getMiddlename());
		dto.setGender(entity.getGender().toString());
		dto.setBirthDate(entity.getBirthDate());
		dto.setEmployed(entity.getEmployed());
		dto.setGeneralWeightedAverage(entity.getGeneralWeightedAverage());
		
		
		dto.setBarangay(entity.getAddress().getBarangay());
		dto.setCity(entity.getAddress().getCity());
		dto.setHouseNumber(entity.getAddress().getHouseNumber());
		dto.setStreet(entity.getAddress().getStreet());
		dto.setSubdivision(entity.getAddress().getSubdivision());
		dto.setZipCode(entity.getAddress().getZipCode());
		
		dto.setContactType(entity.getContact().getType().toString());
		dto.setContactNumber(entity.getContact().getContactNumber());
		
		RoleDTO roleDto = null;
		List<RoleDTO> rolesDto = new ArrayList<RoleDTO>();
		/** FOR SELECTED ROLES AND OTHER ROLES **/
		for(RoleDTO role:roleService.getAll()){
			
			roleDto = new RoleDTO();
			roleDto.setId(role.getId());
			roleDto.setRoleName(role.getRoleName());
			roleDto.setSelected(checkIfSelectedRole(role.getId(),entity.getRoles()));
			rolesDto.add(roleDto);
			
		}
		dto.setRoles(rolesDto);
		
		/** FOR SELECTED ROLES **/
		rolesDto = new ArrayList<RoleDTO>();
		for(RoleEntity role:entity.getRoles()){
			
			roleDto = new RoleDTO();
			roleDto.setId(role.getId());
			roleDto.setRoleName(role.getRoleName());
			roleDto.setSelected(checkIfSelectedRole(role.getId(),entity.getRoles()));
			rolesDto.add(roleDto);
			
		}
		dto.setSelectedRoles(rolesDto);
		
		return dto;
	}
	
	private Boolean checkIfSelectedRole(Long id,Set<RoleEntity> selectedRolesByEmployee){
		for(RoleEntity role:selectedRolesByEmployee){
			if(role.getId()==id){
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	
	public List<EmployeeDTO> getDataTransferFromListOfEmployeesEntity(List<EmployeeEntity> listOfEmployeeEntity){
		List<EmployeeDTO> listOfDataTransfer = new ArrayList<EmployeeDTO>();
		for(EmployeeEntity entity:listOfEmployeeEntity){
			listOfDataTransfer.add(getDataTransferFromEmployeeEntity(entity));
		}
		return listOfDataTransfer;
	}
	
	
	
	
	
}
