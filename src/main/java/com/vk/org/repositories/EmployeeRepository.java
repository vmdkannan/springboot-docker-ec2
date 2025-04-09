package com.vk.org.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.vk.org.entities.Employee;
import java.lang.Integer;
import java.lang.String;

@RepositoryRestResource(collectionResourceRel = "employee", path = "employee")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	@Query(value = "SELECT e.employee_id, e.first_name, e.last_name, e.address, e.email FROM employee e "+
            "join employee_bank eb " +
            "on e.employee_id = eb.employee_id " +
            "join bank b " +
            "on b.bank_id = eb.bank_id " +
            "where b.bank_id = :bId", nativeQuery = true)
	List<Employee> findEmployeesByBankId(@Param("bId") Integer bId);
	
	
	List<Employee> findByEmployeeId(Integer employeeid);
	
	List<Employee> findByFirstName(String firstname);


}
