package com.Examole.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.Examole.demo.Entity.Emp;


public interface EmpRepo extends JpaRepository<Emp, Integer> {

	@Transactional
	@Modifying
	@Query(value = "insert into Emp(name,salary) values(:name,:salary)" )
	void insert(String name,Double salary);
	
	@Query("select name,salary from Emp")
	List<Object[]> EmpNameAndSalary();
}
