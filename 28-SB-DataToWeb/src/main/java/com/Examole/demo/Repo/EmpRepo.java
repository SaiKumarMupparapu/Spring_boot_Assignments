package com.Examole.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Examole.demo.Entity.Employee;

public interface EmpRepo extends JpaRepository<Employee, Long> {

}