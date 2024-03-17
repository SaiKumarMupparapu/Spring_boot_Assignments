package com.Examole.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Examole.demo.Entity.Employee;
import com.Examole.demo.Repo.EmpRepo;
import com.Examole.demo.Service.EmpService;

@Controller
public class EmpController {

	private EmpRepo er;
	private EmpService es;
	
	public EmpController(EmpRepo er,EmpService es) {
		this.er=er;
		this.es=es;
	}
	
	@GetMapping("/emplist")
	public ModelAndView postEmp() {
		ModelAndView mv= new ModelAndView();
		List<Employee> allEmp = es.getAllEmp(er);
		mv.addObject("emp", allEmp);
		mv.setViewName("emptable");
		
		return mv;
	}
}
