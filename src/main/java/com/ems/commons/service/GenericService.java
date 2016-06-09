package com.ems.commons.service;

import java.io.Serializable;
import java.util.List;

import com.ems.commons.exception.EntityAlreadyExistException;
import com.ems.commons.exception.EntityNotFoundException;

public interface GenericService<T,ID extends Serializable> {
	
	String ENTITY_ALREADY_EXIST_MSG = "ENTITY ALREADY EXIST.";
	String ENTITY_NOT_FOUND_MSG = "ENTITY NOT FOUND.";
	
	T getById(ID id) throws EntityNotFoundException;
	void saveOrUpdate(T entity) throws EntityAlreadyExistException;
	void deleteById(ID id) throws EntityNotFoundException;
	List<T> getAll();
	
}
