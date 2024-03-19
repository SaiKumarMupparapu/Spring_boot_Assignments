package com.Examole.demo.ServiceInteface;

import java.util.List;

import com.Examole.demo.Entity.Product;

public interface ProductServiceInterface {
	
	public Boolean save(Product p);
	public List<Product> GetPrdList();
	public void deleteRecord(Long id);
	public Product getPrdById(Long id);
	

}
