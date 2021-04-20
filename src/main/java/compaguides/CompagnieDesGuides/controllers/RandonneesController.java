package compaguides.CompagnieDesGuides.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import compaguides.CompagniesDesGuides.model.RandonneesRepository;

@RestController
public class RandonneesController {
	@Autowired
	private RandonneesRepository randonneesrepository;
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/randonnees")
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("randonnees",randonneesrepository.findAll());
		mav.setViewName("randonnees-all");
		return mav;	
	}
}
