package projet.cdg.compagnieDesGuides.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;

import java.util.Optional;

@RestController
public class RandonneesController {
	
	@Autowired
	private RandonneesRepository randonneesRepository;
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/randonnees")
	public ModelAndView mesRandonnees() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("randonnees",randonneesRepository.findAll());
		mav.setViewName("randonnees-all");
		return mav;	
	}

}
