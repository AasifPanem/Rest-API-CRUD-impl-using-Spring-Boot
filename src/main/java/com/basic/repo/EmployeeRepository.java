package com.basic.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basic.Entity.Employee;
import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByName(String name);
}
