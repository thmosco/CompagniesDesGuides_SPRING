package projet.cdg.compagnieDesGuides.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.repository.ConcernerRepository;
import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ConcernerController {

	@Autowired
	private RandonneesRepository randonneesRepository;
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
	@GetMapping("/concerner-delete/{idSommet}/{idConcerner}")
	public ModelAndView concernerModif(@PathVariable int idSommet,
	@PathVariable int idConcerner) {
		ModelAndView mav = new ModelAndView("redirect:/randonnees");
		concernerRepository.deleteConcerner(idSommet, idConcerner);
		mav.addObject("randonnees",randonneesRepository.findAll());
		mav.addObject("id",idConcerner);
		mav.setViewName("randonnees-all");
		return mav;	
	}
	@PostMapping("/concerner-update-form/{idSommet}/{idConcerner}")
	public ModelAndView concernerModif(@PathVariable int idSommet,
	@PathVariable int idConcerner,
	@RequestParam(value="dateDebut", defaultValue="null") String dateDebut,
	@RequestParam(value="dateFin", defaultValue="null") String dateFin,
	@RequestParam(value="dateConcerner", defaultValue="null") String dateConcerner) throws ParseException {
		ModelAndView mav = new ModelAndView("redirect:/randonnees");
		System.out.println("test");
		String erreur = "";
		if(!isValid(dateConcerner, "yyyy-MM-dd")) {
			erreur += "Date Concernée incorrect <br>";
		} else {
			if(!isValid(dateDebut, "yyyy-MM-dd")) {
				erreur += "Date de début incorrect <br>";
			} else {
				if(!isValid(dateFin, "yyyy-MM-dd")) {
					erreur += "Date de fin incorrect <br>";
				} else {	
					if(dateConcerner.compareTo(dateFin)>0  || dateDebut.compareTo(dateConcerner)>0) {
						erreur += "Date abris en dehors du planning de la randonnée <br>";
					} else {
							concernerRepository.updateConcerner1(idSommet, idConcerner, dateConcerner);
					}
				}
			}
		}
		mav.addObject("erreur",erreur);
		mav.addObject("randonnees",randonneesRepository.findAll());
		mav.addObject("id",idConcerner);
		mav.setViewName("randonnees-all");
		return mav;	
	}
}
