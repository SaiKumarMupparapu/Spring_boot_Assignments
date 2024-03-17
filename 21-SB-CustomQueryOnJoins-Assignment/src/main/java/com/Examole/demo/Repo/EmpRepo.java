package com.Examole.demo.Repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Examole.demo.Entity.EmployeeWithAdrs;

public interface EmpRepo extends JpaRepository<EmployeeWithAdrs, Long> {
	@Query("select e , a from EmployeeWithAdrs e join Address a on e.id=a.aid")
	List<Object[]>getEmpWithAddrs();
 }
