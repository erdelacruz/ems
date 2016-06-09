package com.ems.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.employee.domain.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
