package com.basic.service;

import java.util.List;

import com.basic.Entity.Employee;

public interface EmployeeService {
	
	public String createEmployee(Employee employee);
	public String updateEmployee(Employee employee);
	public String deleteEmployee(int empId);
	public Employee getEmployee(int empId);
	public List<Employee> getAllEmployee();
	
}
