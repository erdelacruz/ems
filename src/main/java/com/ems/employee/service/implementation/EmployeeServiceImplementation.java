package com.ems.employee.service.implementation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.commons.exception.EntityAlreadyExistException;
import com.ems.commons.exception.EntityNotFoundException;
import com.ems.employee.domain.dto.EmployeeDTO;
import com.ems.employee.domain.dto.SearchEmployeeDTO;
import com.ems.employee.domain.entity.EmployeeEntity;
import com.ems.employee.domain.utility.EmployeeDataTransferUtility;
import com.ems.employee.repository.EmployeeRepository;
import com.ems.employee.service.EmployeeService;
@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	@Resource
	private EmployeeRepository dao;
	@Autowired
	private EmployeeDataTransferUtility dataTransferUtility;
	
	@Override
	@Transactional
	public EmployeeDTO getById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		EmployeeEntity employee =dao.findOne(id);
		
		if(employee==null){
			throw new EntityNotFoundException(ENTITY_NOT_FOUND_MSG);
		}
		return dataTransferUtility.getDataTransferFromEmployeeEntity(employee);
	}

	@Override
	@Transactional
	public void saveOrUpdate(EmployeeDTO dto) throws EntityAlreadyExistException {
		// TODO Auto-generated method stub
		
		if(dto.getId()==null){
			int existingEmployeeCount = dao.countByFirstnameAndLastnameAndMiddlename(dto.getFirstname(), dto.getLastname(), dto.getMiddlename()).size();
			if(existingEmployeeCount>0){
				throw new EntityAlreadyExistException(ENTITY_ALREADY_EXIST_MSG);
			}
		}
		dao.save(dataTransferUtility.getEmployeeEntityFromDataTransfer(dto));
	}

	@Override
	@Transactional
	public void deleteById(Long id) throws EntityNotFoundException {
		EmployeeEntity employee =dao.findOne(id);
		if(employee==null){
			throw new EntityNotFoundException(ENTITY_NOT_FOUND_MSG);
		}
		dao.delete(employee);
	}

	@Override
	@Transactional
	public List<EmployeeDTO> getAll() {
		return dataTransferUtility.getDataTransferFromListOfEmployeesEntity(dao.findAllOrderByFirstnameAsc());
	}
	
	

	public void setDao(EmployeeRepository dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public List<EmployeeDTO> getEmployeeBy(SearchEmployeeDTO searchQuery) {
		// TODO Auto-generated method stub
		List<EmployeeDTO> results = dataTransferUtility.getDataTransferFromListOfEmployeesEntity(
				dao.findBy(searchQuery.getFirstname(), 
						   searchQuery.getLastname(), 
						   searchQuery.getMiddlename(), 
						   searchQuery.getRoleId())
				);
		return results;
	}
	
	

	

}
