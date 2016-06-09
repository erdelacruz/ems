package com.ems.employee.service.implementation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.commons.exception.EntityAlreadyExistException;
import com.ems.commons.exception.EntityNotFoundException;
import com.ems.employee.domain.dto.RoleDTO;
import com.ems.employee.domain.entity.RoleEntity;
import com.ems.employee.domain.utility.EmployeeDataTransferUtility;
import com.ems.employee.domain.utility.RoleDataTransferUtility;
import com.ems.employee.repository.RoleRepository;
import com.ems.employee.service.RoleService;
@Service
public class RoleServiceImplementation implements RoleService {
	
	@Resource
	private RoleRepository dao;
	@Autowired
	private RoleDataTransferUtility dataTransferUtility;

	@Override
	public RoleDTO getById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return dataTransferUtility.getDataTransferFromRoleEntity(dao.findOne(id));
	}

	@Override
	public void saveOrUpdate(RoleDTO dto) throws EntityAlreadyExistException {
		// TODO Auto-generated method stub
		dao.save(dataTransferUtility.getRoleEntityFromDataTransfer(dto));
	}

	@Override
	public void deleteById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public List<RoleDTO> getAll() {
		// TODO Auto-generated method stub
		return dataTransferUtility.getDataTransferFromListOfRoleEntity(dao.findAll());
	}

}
