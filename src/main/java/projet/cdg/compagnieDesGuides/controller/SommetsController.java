package projet.cdg.compagnieDesGuides.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.repository.SommetsRepository;

import java.util.Optional;

@RestController
public class SommetsController {
	
	@Autowired
	private SommetsRepository sommetsRepository;
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/sommets")
	public ModelAndView mesRandonnees() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("sommets",sommetsRepository.findAll());
		mav.setViewName("sommets-all");
		return mav;	
	}

}
