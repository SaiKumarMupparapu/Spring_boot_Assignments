package com.Examole.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Examole.demo.Binding.Product;


public interface PrdRepo extends JpaRepository<Product, Long> {

}
