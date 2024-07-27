package com.basic.cont;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.Entity.Employee;
import com.basic.response.ResponseHandler;
import com.basic.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmpController {
	
	EmployeeService employeeService;  	
	
	public EmpController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("{empId}")
	public ResponseEntity<Object> getEmployee(@PathVariable("empId") int empId) {
		return ResponseHandler.responseBuilder(" Requested EMPLOYEE details are given here ", HttpStatus.OK, employeeService.getEmployee(empId));
	}
	
	@GetMapping()
	public List<Employee> getEmployee() {
		return employeeService.getAllEmployee();
	}
	
	@PostMapping
	public String createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return "Employee Create successfully";
	}

	@PutMapping
	public String updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
		return "Employee update successfully";
	}
	
	@DeleteMapping("{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId) {
		employeeService.deleteEmployee(empId);
		return "Employee Delete successfully";
	}
}
