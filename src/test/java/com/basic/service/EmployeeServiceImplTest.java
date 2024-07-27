package com.basic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.basic.Entity.Employee;
import com.basic.repo.EmployeeRepository;

class EmployeeServiceImplTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	private EmployeeService employeeService;
	AutoCloseable autoCloseable;
	Employee employee;

	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		employeeService = new EmployeeServiceImpl(employeeRepository);
		employee = new Employee(10, "Aasif", "XXX");
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	@Test
	void testCreateEmployee() {
		mock(Employee.class);
		mock(EmployeeRepository.class);
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.createEmployee(employee)).isEqualTo("Success");
	}
	
	@Test
	void testUpdateEmployee() {
		mock(Employee.class);
		mock(EmployeeRepository.class);
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.updateEmployee(employee)).isEqualTo("Success");
	}

}
