package projet.cdg.compagnieDesGuides.controller;


import org.hibernate.Transaction;
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
import projet.cdg.compagnieDesGuides.model.ReserverModel;
import projet.cdg.compagnieDesGuides.keys.ConcernerKey;
import projet.cdg.compagnieDesGuides.keys.ReserverKey;
import projet.cdg.compagnieDesGuides.model.AbrisModel;
import projet.cdg.compagnieDesGuides.model.ConcernerModel;
import projet.cdg.compagnieDesGuides.model.GuidesModel;
import projet.cdg.compagnieDesGuides.model.RandonneesModel;
import projet.cdg.compagnieDesGuides.model.SommetsModel;
import projet.cdg.compagnieDesGuides.repository.AbrisRepository;
import projet.cdg.compagnieDesGuides.repository.ConcernerRepository;
import projet.cdg.compagnieDesGuides.repository.GuidesRepository;
import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;
import projet.cdg.compagnieDesGuides.repository.ReserverRepository;
import projet.cdg.compagnieDesGuides.repository.SommetsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@RestController
public class RandonneesController {
	
	@Autowired
	private RandonneesRepository randonneesRepository;
	@Autowired
	private AbrisRepository abrisRepository;
	@Autowired
	private ReserverRepository reserverRepository;
	@Autowired
	private ConcernerRepository concernerRepository;
	@Autowired
	private ApplicationContext context;
	
	public static boolean isValid(String strdate, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            Date date = df.parse(strdate);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
	@PostMapping("/randonnees-update-form/{id}")
	public ModelAndView randonneesModif(@PathVariable int id,
	@RequestParam(value="dateDebut", defaultValue="null") String dateDebut,
	@RequestParam(value="dateFin", defaultValue="null") String dateFin,
	@RequestParam(value="nbPersonne", defaultValue="null") String nbPersonne) throws ParseException {
		String erreur = "";
		if(!isValid(dateDebut, "yyyy-MM-dd")) {
			erreur += "Date de début incorrect <br>";
		} else {
			if(!isValid(dateFin, "yyyy-MM-dd")) {
				erreur += "Date de fin incorrect <br>";
			} else {
				if(!nbPersonne.matches("[+-]?\\d*(\\.\\d+)?")) {
					erreur += "nbPersonne incorrect <br>";
				} else {
					if(dateDebut.compareTo(dateFin)>=0) {
						erreur += "Date de début plus grande que date de fin <br>";
					} else {
						if(ChronoUnit.DAYS.between(LocalDate.parse(dateDebut),LocalDate.parse(dateFin)) > 15) {
							erreur += "Plus de 15 jours de randonnées <br>";
						} else {
							randonneesRepository.update(id, nbPersonne, dateDebut, dateFin);
							reserverRepository.updateReserver(dateDebut, dateFin);
							concernerRepository.updateConcerner(dateDebut, dateFin);
						}
					}
				}
			}
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("erreur",erreur);
		mav.addObject("randonnees",randonneesRepository.findAll());
		mav.addObject("id",id);
		mav.setViewName("randonnees-all");
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
		    
		    mav.addObject("sommets",sommetsRepository.findAllById(iterableSommets));
		  
			String a = abris.get(0);
			
		if(!a.contentEquals("null")) {
			Iterable<AbrisModel> abrisModel;
			AbrisRepository abrisRepository = (AbrisRepository) context.getBean("abrisRepository");
		    
			List<Integer> intListAbris = new ArrayList<Integer>();// Converti les choix en list de integer
			for(String a1:abris) intListAbris.add(Integer.valueOf(a1));
			
			Iterable<Integer> iterableAbris = intListAbris;
		
		    mav.addObject("abris",abrisRepository.findAllById(iterableAbris));
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
	public ModelAndView creationRandonnees(@RequestParam(value="personnes", defaultValue="null") String personnes,
											@RequestParam(value="debut", defaultValue="null") String debut,
											@RequestParam(value="fin", defaultValue="null") String fin,
											@RequestParam(value="sommets", defaultValue="null") List<String> sommets,
											@RequestParam(value="dateSommet", defaultValue="null") List<String> dateSommets,
											@RequestParam(value="abris", defaultValue="null") List<String> abris,
											@RequestParam(value="dateAbris", defaultValue="null") List<String> dateAbris) {
		ModelAndView mav = new ModelAndView();
				
				String lS = sommets.get(0);
				String dS = dateSommets.get(0);
				
				String lA = abris.get(0);
				String dA = abris.get(0);
				
			if(!personnes.contentEquals("null") && !debut.contentEquals("null") && !fin.contentEquals("null") && !lS.contentEquals("null")  && !dS.contentEquals("null")) {
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
					    					   mav.addObject("erreur", "La date d'un sommet n'est pas dans la date de la randonnée");
					    					   mav.setViewName("erreur");
									    	   return mav;
					    				   }
					    			   }
					    			   
					    			   if(!lA.contentEquals("null") && !dA.contentEquals("null")) {// Je vérifie si il a des abris
					    				   if(abris.size() == dateAbris.size()) {// je regarde si chaque abris a une date associé
					    					   
					    					   for(String dates:dateAbris) {// je vérifie si les date donnée correspondent aux date de la randonnées
							    				   Date dateVerifAbris =  new Date();
							    				   try {
							    					  dateVerifAbris = new SimpleDateFormat("yyyy-MM-dd").parse(dates);
												} catch (ParseException e) {
													e.printStackTrace();
												}
							    				   if(dateVerifAbris.after(finDate) || dateVerifAbris.before(debutDate)) {
							    					   mav.addObject("erreur", "La date d'un abris n'est pas dans la date de la randonnée");
							    					   mav.setViewName("erreur");
											    	   return mav;
							    					   
							    				   }
							    			   }
					    					   
					    				   }else {
					    					   mav.addObject("erreur", "Il manque une date à un abris");
					    					   mav.setViewName("erreur");
									    	   return mav;}
					    			   }
					    			   Iterable<GuidesModel> guidesModel;
					    				GuidesRepository guidesRepository = (GuidesRepository) context.getBean("guidesRepository");
					    			   
					    			   RandonneesModel r = new RandonneesModel();
					    			   
					    			   r.setGuide(guidesRepository.findById(1).get());
					    			   r.setDate_debut(debut);
					    			   r.setDate_fin(fin);
					    			   r.setNombres_personnes(Integer.parseInt(personnes));
					    			   
					    			   randonneesRepository.save(r);
					    			   
					    			   Iterable<SommetsModel> sommetsModel;
					    				SommetsRepository sommetsRepository = (SommetsRepository) context.getBean("sommetsRepository");
					    				
					    				Iterable<ConcernerModel> concernerModel;
					    				ConcernerRepository concernerRepository = (ConcernerRepository) context.getBean("concernerRepository");
					    				
					    				List<Integer> intListSommets = new ArrayList<Integer>();// Converti les choix en list de integer
					    				for(String s1:sommets) intListSommets.add(Integer.valueOf(s1));
					    				
					    				HashMap<Integer, String> sommetWithDate = new HashMap<Integer, String>();
					    				
					    				  for (int i=0; i<intListSommets.size(); i++) {
					    				      sommetWithDate.put(intListSommets.get(i), dateSommets.get(i));//J'associe chaque sommet à sa date
					    				    }
					    				  
					    			   
					    			   for (Integer i : sommetWithDate.keySet()) {
					    				   ConcernerModel concernerSommet = new ConcernerModel();
					    				   
						    				   ConcernerKey concernerKey = new ConcernerKey();
						    				   
						    				   concernerKey.setCoderandonnees(r.getId());
						    				   concernerKey.setCodesommets(i);
					    				   
					    				   concernerSommet.setId(concernerKey);
					    				   concernerSommet.setDate_concerner(sommetWithDate.get(i));
					    				   concernerSommet.setRandonnees(r);
					    				   concernerSommet.setSommets(sommetsRepository.findById(i).get());
					    				   
					    				   concernerRepository.save(concernerSommet);
					    			   }
					    			   
					    			   if(!lA.contentEquals("null") && !dA.contentEquals("null")) {
					    				   
					    				   Iterable<AbrisModel> abrisModel;
						    				AbrisRepository abrisRepository = (AbrisRepository) context.getBean("abrisRepository");
						    				
						    				Iterable<ReserverModel> reserverModel;
						    				ReserverRepository reserverRepository = (ReserverRepository) context.getBean("reserverRepository");
						    				
						    				List<Integer> intListAbris = new ArrayList<Integer>();// Converti les choix en list de integer
						    				for(String a1:abris) intListAbris.add(Integer.valueOf(a1));
						    				
						    				HashMap<Integer, String> abrisWithDate = new HashMap<Integer, String>();
						    				
						    				  for (int i=0; i<intListAbris.size(); i++) {
						    				      abrisWithDate.put(intListAbris.get(i), dateAbris.get(i));//J'associe chaque abris à sa date
						    				    }
						    				  
						    			   
						    			   for (Integer i : abrisWithDate.keySet()) {
						    				   ReserverModel reserverAbris = new ReserverModel();
						    				   
							    				   ReserverKey reserverKey = new ReserverKey();
							    				   
							    				   reserverKey.setCode_Randonnees(r.getId());
							    				   reserverKey.setCode_Abris(i);;
						    				   
							    				reserverAbris.setId(reserverKey);
							    				reserverAbris.setDate_Reserver(abrisWithDate.get(i));
							    				reserverAbris.setRandonnees(r);
							    				reserverAbris.setAbris(abrisRepository.findById(i).get());
							    				reserverAbris.setStatut_Reserver("en attente");
						    				   
							    				reserverRepository.save(reserverAbris);
						    			   }
					    				   
					    			   }
					    			   
					    			   
					    		
					    		return new ModelAndView("redirect:/randonnees");}
					    	   }
					    	   mav.addObject("erreur", "La randonnée ne doit pas excéder 15 jours");
					    	   mav.setViewName("erreur");
					    	   return mav;
							}
					    mav.addObject("erreur", "Les dates de la randonnée ne sont pas correct");
					    mav.setViewName("erreur");
						return mav;
						}
			mav.addObject("erreur", "Il vous faut saisir tout les champs dans votre randonnée !");
			mav.setViewName("erreur");
			return mav;
		}
	
	}




