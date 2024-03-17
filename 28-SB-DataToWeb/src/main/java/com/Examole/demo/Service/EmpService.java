
package com.Examole.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Examole.demo.Entity.Employee;
import com.Examole.demo.Repo.EmpRepo;

@Service
public class EmpService {

	public List<Employee> getAllEmp(EmpRepo er){
		
		List<Employee> list = er.findAll();
		return list;
	}


}
