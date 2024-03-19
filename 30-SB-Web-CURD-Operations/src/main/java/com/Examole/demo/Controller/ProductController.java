package com.Examole.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Examole.demo.Entity.Product;
import com.Examole.demo.ServiceImpl.ProductServiceImplementation;

@Controller
public class ProductController {

	@Autowired
	private ProductServiceImplementation prdService;

	@GetMapping("/form")
	public ModelAndView loadForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prdObj", new Product());
		mav.setViewName("form");
		return mav;
	}

	@PostMapping("/prdSaved")
	public ModelAndView saved(Product p) {
		Boolean saved = prdService.save(p);
		
		ModelAndView mav = new ModelAndView();

		if(saved) mav.addObject("sMsg", "Record saved");
		else mav.addObject("eMsg", "Record not saved");

		
		mav.setViewName("form");
		mav.addObject("prdObj", new Product());

		return mav;
	}
	
	
	@GetMapping("/plist")
	public ModelAndView productList() {
		List<Product> prdList = prdService.GetPrdList();
		
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",prdList);
		mav.setViewName("prdListForm");
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView deleteRecord(@PathVariable("id") Long id) {
		 prdService.deleteRecord(id);
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/plist");
			return mav;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editForm(@PathVariable("id") Long id) {
		
	    Product prd = prdService.getPrdById(id);
	
		ModelAndView mav= new ModelAndView();
		mav.addObject("product",prd);
		mav.setViewName("editform");
		
		return mav;
	}
	
	@PostMapping("/prdUpdated")
	public ModelAndView updated(@ModelAttribute Product p) {
		 prdService.save(p);
		ModelAndView mav= new ModelAndView();
		mav.setViewName("redirect:/plist");
		return mav;
	}
	


}
