package com.vk.org.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vk.org.entities.Employee;
import com.vk.org.repositories.EmployeeRepository;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(){
		return (List<Employee>) employeeRepository.findAll();
	}


	@Override
	public Employee getEmployee(Integer tId) {
		
//		Employee emp = new Employee();
//		if(employeeRepository.findOne(tId).equals(emp)){
//			throw new IdNotFoundException(tId);
//		}else {
//			return employeeRepository.findOne(tId);
//		}
		
		return employeeRepository.getOne(tId);
		
	}


	@Override
	public List<Employee> findEmployeesByBankId(Integer bId) {
		return employeeRepository.findEmployeesByBankId(bId);
	}


	@Override
	public Employee updateEmployee(Employee emp) {
            Employee newEntity = employeeRepository.getOne(emp.getEmployeeId());
            newEntity.setAddress(emp.getAddress());
                newEntity.setEmail(emp.getEmail());
                newEntity.setFirstName(emp.getFirstName());
                newEntity.setLastName(emp.getLastName());
                employeeRepository.save(newEntity);
                return newEntity;
        }



	@Override
	public List<Employee> findByEmployeeId(Integer employeeid) {
		return employeeRepository.findByEmployeeId(employeeid);
	}


	@Override
	public void addEmployee(Employee empUp) {
		employeeRepository.saveAndFlush(empUp);
	}

}
