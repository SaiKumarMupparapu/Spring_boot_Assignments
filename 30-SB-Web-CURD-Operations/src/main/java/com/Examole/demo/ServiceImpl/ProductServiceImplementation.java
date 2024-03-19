package com.Examole.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Examole.demo.Entity.Product;
import com.Examole.demo.Repo.ProductRepo;
import com.Examole.demo.ServiceInteface.ProductServiceInterface;

@Service
public class ProductServiceImplementation implements ProductServiceInterface {

	@Autowired
	private ProductRepo prdRepo;

	@Override
	public Boolean save(Product p) {
		Product save = prdRepo.save(p);

		return save.getpId() != null;
	}

	@Override
	public List<Product> GetPrdList() {

		return prdRepo.findAll();

	}

	@Override
	public void deleteRecord(Long id) {
		
		prdRepo.deleteById(id);
		
		
	}

	@Override
	public Product getPrdById(Long id) {

		 Optional<Product> optional = prdRepo.findById(id);
		 Product product = null;
		 if(optional.isPresent()) {
			 product=optional.get();
			 
		 }
		 return product;
		
	}

	

}
