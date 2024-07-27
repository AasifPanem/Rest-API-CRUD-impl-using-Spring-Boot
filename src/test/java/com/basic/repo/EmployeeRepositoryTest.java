package com.basic.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.basic.Entity.Employee;
import com.basic.repo.EmployeeRepository;


@DataJpaTest
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	private Employee employee;	

	@BeforeEach
	void setUp() {
		employee = new Employee(10, "Aasif", "Team-Lead");
		employeeRepository.save(employee);
	}

	@AfterEach
	void tearDown() {
		employee = null;
		employeeRepository.deleteAll();
	}
	
	@Test
	public void testByFindByEmployeeName_Found() {
		List<Employee> employeeList = employeeRepository.findByName("Aasif");
		assertThat(employeeList.get(0).getId().equals(employee.getId()));
		assertThat(employeeList.get(0).getDesignation().equals(employee.getDesignation()));
	}
	
	@Test
	public void testByFindByEmployeeName_NotFound() {
		List<Employee> employeeList = employeeRepository.findByName("XXX");
		assertThat(employeeList.isEmpty()).isTrue();
	}

}
