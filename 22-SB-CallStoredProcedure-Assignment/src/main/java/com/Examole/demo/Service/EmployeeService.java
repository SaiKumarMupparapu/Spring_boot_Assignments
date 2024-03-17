package com.Examole.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Examole.demo.Entity.Employee;
import com.Examole.demo.Repo.EmployeeRepo;

@Service
public class EmployeeService {

	private EmployeeRepo er;

	@Autowired
	public EmployeeService(EmployeeRepo er) {
		this.er = er;
	}
	
	public void saveEmp() {
		Employee emp=new Employee();
		emp.setName("sai");
		emp.setSalary(1234345.0);
		er.save(emp);
	}
	
	@Transactional
	public void getEmpsByStoredProcedure() {
		List<Employee> empList = er.getEmp();
	 
		empList.forEach(System.out::println);
		
	}
	
}
