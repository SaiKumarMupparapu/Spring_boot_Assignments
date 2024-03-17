package com.Examole.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Examole.demo.Entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer,String> {

}
