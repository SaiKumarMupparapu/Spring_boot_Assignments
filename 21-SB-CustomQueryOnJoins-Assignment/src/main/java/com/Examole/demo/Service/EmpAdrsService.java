package com.Examole.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Examole.demo.Entity.Address;
import com.Examole.demo.Entity.EmployeeWithAdrs;
import com.Examole.demo.Repo.AddressRepo;
import com.Examole.demo.Repo.EmpRepo;

@Service
public class EmpAdrsService {

	private EmpRepo er;
	private AddressRepo aRepo;

	public EmpAdrsService(EmpRepo er, AddressRepo aRepo) {
		this.er = er;
		this.aRepo = aRepo;
	}

	public void saveEmpWithAdrs() {
		Address adrs = new Address();

		EmployeeWithAdrs emp = new EmployeeWithAdrs();
		emp.setName("sai");
		emp.setSalary(1234567.0);

		adrs.setCity("khammam");
		adrs.setState("Telangana");
		adrs.setCountry("Bharath");
		aRepo.save(adrs);
		emp.setAdrs(adrs);
		er.save(emp);
		System.out.println("record saved");
	}

	public void getEmpAlongWithAddrs() {
		List<Object[]> empWithAddrs = er.getEmpWithAddrs();
		for (Object[] o : empWithAddrs) {
			System.out.println(o[0] + "\t" + o[1]);
		}
	}

}
