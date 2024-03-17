package com.Jpa.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jpa.Entity.Person;

public interface personRepo extends JpaRepository<Person, Integer>{

}
