package com.ems.user.service.implementation;

import java.util.List;

import com.ems.commons.exception.EntityAlreadyExistException;
import com.ems.commons.exception.EntityNotFoundException;
import com.ems.user.domain.entity.UserEntity;
import com.ems.user.service.UserService;

public class UserServiceImplementation implements UserService{

	@Override
	public UserEntity getById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(UserEntity entity) throws EntityAlreadyExistException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
