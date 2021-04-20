package compaguides.CompagnieDesGuides;

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
	private RandonneesRepository randonneesRepository;
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/randonnees")
	public ModelAndView mesRandonnees() {
		ModelAndView mav = new ModelAndView();
		System.out.println("rando");
		mav.addObject("randonnees",randonneesRepository.findAll());
		mav.setViewName("randonnees-all");
		return mav;	
	}
	
	@RequestMapping("/randonnees-delete/{id}")
	public ModelAndView delete(@PathVariable int id) {
		randonneesRepository.deleteById(id);
		return new ModelAndView("redirect:/randonnees");
	}
	@GetMapping("/randonnees/{id}")
	public ModelAndView get(@PathVariable int id) {
		//Récuperer l'employé
		Optional<RandonneesModel> e = randonneesRepository.findById(id);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("randonnees", e);
		mav.setViewName("randonnees-get");
		return mav;
	}
}
