package com.Examole.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Examole.demo.Repo.EmpRepo;

@Service
public class EmpService {
	private EmpRepo er;

	public EmpService(EmpRepo er) {
		this.er = er;
	}

	public void insertEmp() {
		er.insert("vijay", 1245.00);
	}

	public void getEmp() {
		List<Object[]> nameAndSalary = er.EmpNameAndSalary();
		for (Object[] list : nameAndSalary) {
			String name = (String) list[0];
			Double salary = (Double) list[1];
			System.out.println(name + "\t" + salary);
		}
	}

}
