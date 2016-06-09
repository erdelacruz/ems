package com.ems.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.employee.domain.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Query(value ="select * from employee_table as e where"
			+ " LOWER(e.firstname) = LOWER(?1) AND"
			+ " LOWER(e.lastname) = LOWER(?2) AND"
			+ " LOWER(e.middlename) = LOWER(?3) AND"
			+ " e.emplyee_id in (select r.emplyee_id from employee_role as r where r.role_id=?4 )"
			,nativeQuery = true)
	 List<EmployeeEntity> findBy(String firstname,
			 					String lastname,
			 					String middlename,
			 					Long roleId);
	
	@Query(value ="select * from employee_table as e order by e.firstname ASC "
			,nativeQuery = true)
	List<EmployeeEntity> findAllOrderByFirstnameAsc();
	
	@Query(value ="select * from employee_table as e where "
			+ " LOWER(e.firstname) = LOWER(?1) and"
			+ " LOWER(e.lastname) = LOWER(?2) and"
			+ " LOWER(e.middlename) = LOWER(?3)",nativeQuery = true)
	List<EmployeeEntity> countByFirstnameAndLastnameAndMiddlename(String firstname,
												 String lastname,
												 String middlename);
}
