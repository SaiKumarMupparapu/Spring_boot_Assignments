package com.Examole.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Examole.demo.Entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
