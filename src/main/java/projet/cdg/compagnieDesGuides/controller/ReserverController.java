package projet.cdg.compagnieDesGuides.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.keys.ConcernerKey;
import projet.cdg.compagnieDesGuides.keys.ReserverKey;
import projet.cdg.compagnieDesGuides.model.ConcernerModel;
import projet.cdg.compagnieDesGuides.model.ReserverModel;
import projet.cdg.compagnieDesGuides.repository.AbrisRepository;
import projet.cdg.compagnieDesGuides.repository.ConcernerRepository;
import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;
import projet.cdg.compagnieDesGuides.repository.ReserverRepository;
import projet.cdg.compagnieDesGuides.repository.SommetsRepository;

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
	private ConcernerRepository concernerRepository;
	
	@Autowired
	private AbrisRepository abrisRepository;
	@Autowired
	private SommetsRepository sommetRepository;
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
		String erreur = "";
		if(!isValid(dateReservation, "yyyy-MM-dd")) {
			erreur += "Date de R??servation incorrect <br>";
		} else {
			if(!isValid(dateDebut, "yyyy-MM-dd")) {
				erreur += "Date de d??but incorrect <br>";
			} else {
				if(!isValid(dateFin, "yyyy-MM-dd")) {
					erreur += "Date de fin incorrect <br>";
				} else {	
					if(dateReservation.compareTo(dateFin)>0  || dateDebut.compareTo(dateReservation)>0) {
						erreur += "Date abris en dehors du planning de la randonn??e <br>";
					} else {
						System.out.println(statutReservation);
						if(!statutReservation.equals("Enlever r??servation") && !statutReservation.equals("en attente") && !statutReservation.equals("confirm??")) {
							erreur += "Statut r??servation incorrect";
						} else {
							if(statutReservation.equals("Enlever r??servation")) {
								reserverRepository.deleteReserver(idAbri, idReservation);
							}  else {
								reserverRepository.updateReserver1(idAbri, idReservation, dateReservation, statutReservation);
							}
						}
					}
				}
			}
		}

		return new ModelAndView("redirect:/randonnees");
	}
	@PostMapping("/reserver-ajout-form/{idRandonnee}")
	public ModelAndView reserverAjout(@PathVariable int idRandonnee,
	@RequestParam(value="dateDebut", defaultValue="null") String dateDebut,
	@RequestParam(value="dateFin", defaultValue="null") String dateFin,
	@RequestParam(value="dateReservation", defaultValue="null") String dateReservation,
	@RequestParam(value="ajoutAbris", defaultValue="null") String ajoutAbris) throws ParseException {
		ModelAndView mav = new ModelAndView("redirect:/randonnees");
		System.out.println("test");
		String erreur = "";
		if(!isValid(dateReservation, "yyyy-MM-dd")) {
			erreur += "Date Concern??e incorrecte <br>";
		} else {
			if(!isValid(dateDebut, "yyyy-MM-dd")) {
				erreur += "Date de d??but incorrecte <br>";
			} else {
				if(!isValid(dateFin, "yyyy-MM-dd")) {
					erreur += "Date de fin incorrecte <br>";
				} else {	
					if(dateReservation.compareTo(dateFin)>0  || dateDebut.compareTo(dateReservation)>0) {
						erreur += "Date sommet en dehors du planning de la randonn??e <br>";
					} else {
						if(!sommetRepository.existsById(Integer.valueOf(ajoutAbris))) {
							erreur += "Sommet Non Existant <br>";
						//verif si ??a existe pas d??j??
						} else if(reserverRepository.countReserver(Integer.valueOf(ajoutAbris), idRandonnee) != 0){
							erreur += "Duo Sommet Randonn??e existant<br>";
						} else if(concernerRepository.countSommet(idRandonnee)== 0){
							erreur += "Aucun sommet, donc aucun abris<br>";
						} else {
							ReserverModel reserverModel = new ReserverModel();
							ReserverKey reserverKey = new ReserverKey();
							reserverKey.setCoderandonnees(idRandonnee);
							reserverKey.setCodeabris(Integer.valueOf(ajoutAbris));
							reserverModel.setDate_Reserver(dateReservation);
							reserverModel.setId(reserverKey);
							reserverModel.setRandonnees(randonneesRepository.findById(idRandonnee).get());
							reserverModel.setAbris(abrisRepository.findById(Integer.valueOf(ajoutAbris)).get());
							reserverModel.setStatut_Reserver("en attente");
							reserverRepository.save(reserverModel);
						}
					}
				}
			}
		}
		return new ModelAndView("redirect:/randonnees");
	}
}
