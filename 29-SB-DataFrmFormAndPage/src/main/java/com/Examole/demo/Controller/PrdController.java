package com.Examole.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Examole.demo.Binding.Product;
import com.Examole.demo.Service.PrdService;

@Controller
public class PrdController {

	@Autowired
	private PrdService ps;
	
	@GetMapping("/prdForm")
	public ModelAndView loadForm() {
		ModelAndView mav= new ModelAndView();
		mav.addObject("prdObj", new Product());
		mav.setViewName("prdForm");
		return mav;
	}
	
	@PostMapping("/prdForm")
	public ModelAndView saveProduct(Product pr) {
		
		boolean prdSaved = ps.savePrd(pr);
		
		ModelAndView mav1=new ModelAndView();
		
		String text=null;
		
		if(prdSaved) {
			text="records saved";
		}
		else {
			text="record not saved";
			
		}
		
		mav1.addObject("msg", text);
		mav1.addObject("prdObj", new Product());
		mav1.setViewName("prdForm");
		return mav1;
	}
	
	@GetMapping("/prds")
	public ModelAndView getPrd() {
		List<Product> list = ps.getPrd();
		ModelAndView mav= new ModelAndView();
		mav.addObject("list",list);
		mav.setViewName("prdList");
		return mav;
	}
	
}
