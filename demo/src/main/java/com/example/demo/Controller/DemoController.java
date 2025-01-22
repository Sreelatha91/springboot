package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Alien;
import com.example.demo.Repository.AlienRepo;

@Controller
public class DemoController {
	
	@Autowired
	AlienRepo alienRepo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public ModelAndView addAlien(@ModelAttribute Alien a) {
		alienRepo.save(a);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home.jsp");
		mv.addObject(a);
		return mv;
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aId")int aId) {
		Alien a=alienRepo.getById(aId);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("showAlien.jsp");
		mv.addObject(a);
		return mv;		
	}
	
	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam("aId")int aId) {
		alienRepo.deleteById(aId);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home.jsp");
		return mv;		
	}
	
}
