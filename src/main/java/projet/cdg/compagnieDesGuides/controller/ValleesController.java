package projet.cdg.compagnieDesGuides.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.repository.AbrisRepository;
import projet.cdg.compagnieDesGuides.repository.SommetsRepository;
import projet.cdg.compagnieDesGuides.repository.ValleesRepository;

import java.util.Optional;

@RestController
public class ValleesController {
	
	@Autowired
	private ValleesRepository valleeRepository;
	
	@Autowired
	private AbrisRepository abrisRepository;
	
	@Autowired
	private SommetsRepository sommetsRepository;
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/randonnees/vallees")
	public ModelAndView choisirVallees() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("vallees",valleeRepository.findAll());
		mav.setViewName("vallees-choose");
		return mav;	
	}
	
	@RequestMapping("/randonnees/vallee/{id}")
	public ModelAndView choisirAbrisSommetParVallee(@PathVariable int id) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("sommets",sommetsRepository.findSommetsByVallee(id));
		
		mav.addObject("abris",abrisRepository.findAbrisByVallees(id));
		
		mav.setViewName("sommets-par-vallees");
		return mav;	
	}
	
	@GetMapping("/randonnees/custom")
	public ModelAndView choisirAbrisEtSommets() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("sommets",sommetsRepository.findAll());
		
		mav.addObject("abris",abrisRepository.findAll());
		
		mav.setViewName("randonnees-vierge");
		return mav;	
	}

}
