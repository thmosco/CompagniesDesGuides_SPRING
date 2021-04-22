package projet.cdg.compagnieDesGuides.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.model.RandonneesModel;
import projet.cdg.compagnieDesGuides.model.AbrisModel;
import projet.cdg.compagnieDesGuides.model.RandonneesModel;
import projet.cdg.compagnieDesGuides.model.SommetsModel;
import projet.cdg.compagnieDesGuides.repository.AbrisRepository;
import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;
import projet.cdg.compagnieDesGuides.repository.SommetsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
public class RandonneesController {
	
	@Autowired
	private RandonneesRepository randonneesRepository;
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/randonnees-update-form/{id}")
	public ModelAndView randonneesModif(@PathVariable int id) {
		RandonneesModel r = randonneesRepository.findById(id).get();
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("randonnees",r);
		mav.addObject("randonnees1",randonneesRepository.findById(id));
		mav.setViewName("randonnees-update-form");
		return mav;	
	}
	
	@PostMapping("/randonnees/recap")
	public ModelAndView creationRecapRandonnees(@RequestParam(value="sommets", defaultValue="null") List<String> sommets,
										@RequestParam(value="abris", defaultValue="null") List<String> abris) {
		ModelAndView mav = new ModelAndView();
		
		String s = sommets.get(0);
		
		if(s.contentEquals("null")) {
				String message = "Vous devez sélectionner au moins 1 sommet pour créer une randonnée";
				//redirectAttributes.addFlashAttribute("error", message);
				 mav.setViewName("redirect:/");
				return mav;
		}
		
			Iterable<SommetsModel> sommetsModel;
			SommetsRepository sommetsRepository = (SommetsRepository) context.getBean("sommetsRepository");
		    
			List<Integer> intListSommets = new ArrayList<Integer>();// Converti les choix en list de integer
			for(String s1:sommets) intListSommets.add(Integer.valueOf(s1));
			
			Iterable<Integer> iterableSommets = intListSommets;
		    
		    mav.addObject("sommets",sommetsRepository.findAllById(intListSommets));
		  
			String a = abris.get(0);
			
		if(!a.contentEquals("null")) {
			Iterable<AbrisModel> abrisModel;
			AbrisRepository abrisRepository = (AbrisRepository) context.getBean("abrisRepository");
		    
			List<Integer> intListAbris = new ArrayList<Integer>();// Converti les choix en list de integer
			for(String a1:sommets) intListAbris.add(Integer.valueOf(a1));
			
			Iterable<Integer> iterableAbris = intListAbris;
		
		    mav.addObject("abris",abrisRepository.findAllById(intListAbris));
		}
			
			mav.setViewName("randonnees-recap-creation");
			return mav;
		//mav.addObject("randonnees",randonneesRepository.findAll());
		//mav.setViewName("randonnees-all");
		//return mav;	
	}
	@GetMapping("/randonnees")
	public ModelAndView mesRandonnees() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("randonnees",randonneesRepository.findAll());
		mav.setViewName("randonnees-all");
		return mav;	
	}
	
	@PostMapping("/randonnees/creation")
	public String creationRandonnees(@RequestParam(value="personnes", defaultValue="null") String personnes,
											@RequestParam(value="debut", defaultValue="null") String debut,
											@RequestParam(value="fin", defaultValue="null") String fin,
											@RequestParam(value="sommets", defaultValue="null") List<String> sommets,
											@RequestParam(value="dateSommet", defaultValue="null") List<String> dateSommets,
											@RequestParam(value="abris", defaultValue="null") List<String> abris,
											@RequestParam(value="dateAbris", defaultValue="null") List<String> dateAbris) {
		//ModelAndView mav = new ModelAndView();
				
				String lS = sommets.get(0);
				String dS = dateSommets.get(0);
				
			if(!personnes.contentEquals("null") && !debut.contentEquals("null") && !fin.contentEquals("null") && !lS.contentEquals("null")  && !dS.contentEquals("null")) {
				
				//&& !abris.get(0).isEmpty()  && !dateAbris.get(0).isEmpty() vérifier si les abris sont vide 
					String s = dateSommets.get(0);
				
				    Date debutDate = new Date();
				    Date finDate = new Date();
				    
					try {
						debutDate = new SimpleDateFormat("yyyy-MM-dd").parse(debut); 
						finDate=new SimpleDateFormat("yyyy-MM-dd").parse(fin);
					} catch (ParseException e) {
						e.printStackTrace();
					}
						
					
					    if(debutDate.before(finDate) || debutDate.equals(finDate)) {
					    	   long diff = finDate.getTime() - debutDate.getTime();
					    	   if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)<15) {
					    		   if(sommets.size() == dateSommets.size()) {
					    			
					    			   
					    			   for(String dates:dateSommets) {
					    				   Date dateVerifSommet =  new Date();
					    				   try {
											dateVerifSommet = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
										} catch (ParseException e) {
											e.printStackTrace();
										}
					    				   if(dateVerifSommet.after(finDate) || dateVerifSommet.before(debutDate)) {
					    					   return "La date d'un sommet n'est pas dans la date de la randonnée";
					    				   }
					    			   }
					    			   
					    			   RandonneesModel r = new RandonneesModel();
					    			   
					    			   r.set_guide(1);
					    			   r.setDate_debut(debut);
					    			   r.setDate_fin(fin);
					    			   r.setNombres_personnes(Integer.parseInt(personnes));
					    			   
					    			   randonneesRepository.save(r);
					    			  
					    			   
					    		   return "Randonnées enregistré";}
					    	   }
					    	   return"La randonnée ne doit pas excéder 15 jours";
							}
					    return "Les dates de la randonnée ne sont pas correct";
						}
			return "Il vous faut saisir tout les champs dans votre randonnée !";
		}
	}

