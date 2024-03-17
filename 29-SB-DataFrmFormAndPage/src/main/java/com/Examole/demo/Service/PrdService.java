package com.Examole.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Examole.demo.Binding.Product;
import com.Examole.demo.Repo.PrdRepo;

@Service
public class PrdService {
	@Autowired
	private PrdRepo pr;
	public boolean savePrd(Product prd) {
		pr.save(prd);
		return true;
		
	}
	
	public List<Product> getPrd(){
		List<Product> prdList = pr.findAll();
		return prdList;
	}

}
