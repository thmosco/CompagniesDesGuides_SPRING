package compaguides.CompagnieDesGuides.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import compaguides.CompagniesDesGuides.model.RandonneesModel;
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
	
	@RequestMapping("/randonnees-delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		randonneesrepository.deleteById(id);
		return new ModelAndView("redirect:/employes");
	}
	@GetMapping("/randonnees/{id}")
	public ModelAndView get(@PathVariable int id) {
		//Récuperer l'employé
		Optional<RandonneesModel> e = randonneesrepository.findById(id);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("randonnees", e);
		mav.setViewName("randonnees-get");
		return mav;
	}
}
