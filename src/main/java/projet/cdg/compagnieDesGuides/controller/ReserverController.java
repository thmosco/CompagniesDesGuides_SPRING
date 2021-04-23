package projet.cdg.compagnieDesGuides.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;
import projet.cdg.compagnieDesGuides.repository.ReserverRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ReserverController {

	@Autowired
	private RandonneesRepository randonneesRepository;
	@Autowired
	private ReserverRepository reserverRepository;

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
	@PostMapping("/reserver-update-form/{idAbri}/{idReservation}")
	public ModelAndView reserverModif(@PathVariable int idAbri,
	@PathVariable int idReservation,
	@RequestParam(value="dateDebut", defaultValue="null") String dateDebut,
	@RequestParam(value="dateFin", defaultValue="null") String dateFin,
	@RequestParam(value="dateReservation", defaultValue="null") String dateReservation,
	@RequestParam(value="statutReservation", defaultValue="null") String statutReservation) throws ParseException {
		ModelAndView mav = new ModelAndView("redirect:/randonnees");
		System.out.println("un exemple");
		String erreur = "";
		if(!isValid(dateReservation, "yyyy-MM-dd")) {
			erreur += "Date de Réservation incorrect <br>";
		} else {
			if(!isValid(dateDebut, "yyyy-MM-dd")) {
				erreur += "Date de début incorrect <br>";
			} else {
				if(!isValid(dateFin, "yyyy-MM-dd")) {
					erreur += "Date de fin incorrect <br>";
				} else {	
					if(dateReservation.compareTo(dateFin)>0  || dateDebut.compareTo(dateReservation)>0) {
						erreur += "Date abris en dehors du planning de la randonnée <br>";
					} else {
						System.out.println(statutReservation);
						if(!statutReservation.equals("Enlever réservation") && !statutReservation.equals("en attente") && !statutReservation.equals("confirmé")) {
							erreur += "Statut réservation incorrect";
						} else {
							if(statutReservation.equals("Enlever réservation")) {
								reserverRepository.deleteReserver(idAbri, idReservation);
							}  else {
								reserverRepository.updateReserver1(idAbri, idReservation, dateReservation, statutReservation);
							}
						}
					}
				}
			}
		}
		mav.addObject("erreur",erreur);
		mav.addObject("randonnees",randonneesRepository.findAll());
		mav.addObject("id",idReservation);
		mav.setViewName("randonnees-all");
		return mav;	
	}
}
