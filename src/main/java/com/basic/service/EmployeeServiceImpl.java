package com.basic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.basic.Entity.Employee;
import com.basic.exception.EmployeeNotFoundException;
import com.basic.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public String createEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Success";
	}

	@Override
	public String updateEmployee(Employee employee) {
		employeeRepository.save(employee);
		return "Success";
	}

	@Override
	public String deleteEmployee(int empId) {
		employeeRepository.deleteById(empId);
		return "Success";
	}

	@Override
	public Employee getEmployee(int empId) {
		if (employeeRepository.findById(empId).isEmpty()) {
			throw new EmployeeNotFoundException("Requested Employee does not Exist");
		}
		return employeeRepository.findById(empId).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

}
