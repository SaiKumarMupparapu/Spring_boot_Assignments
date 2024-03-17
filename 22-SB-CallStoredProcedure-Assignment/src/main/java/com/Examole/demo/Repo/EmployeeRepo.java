package com.Examole.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.Examole.demo.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	@Procedure(name="getEmp")
	List<Employee> getEmp();

}
