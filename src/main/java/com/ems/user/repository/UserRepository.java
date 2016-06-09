package com.ems.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.user.domain.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
