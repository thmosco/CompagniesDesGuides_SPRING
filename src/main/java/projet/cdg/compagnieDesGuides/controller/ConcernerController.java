	package projet.cdg.compagnieDesGuides.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.keys.ConcernerKey;
import projet.cdg.compagnieDesGuides.model.ConcernerModel;
import projet.cdg.compagnieDesGuides.model.GuidesModel;
import projet.cdg.compagnieDesGuides.model.RandonneesModel;
import projet.cdg.compagnieDesGuides.repository.AbrisRepository;
import projet.cdg.compagnieDesGuides.repository.ConcernerRepository;
import projet.cdg.compagnieDesGuides.repository.GuidesRepository;
import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;
import projet.cdg.compagnieDesGuides.repository.ReserverRepository;
import projet.cdg.compagnieDesGuides.repository.SommetsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ConcernerController {

	@Autowired
	private AbrisRepository abrisRepository;
	@Autowired
	private SommetsRepository sommetRepository;
	
	@Autowired
	private RandonneesRepository randonneesRepository;
	@Autowired
	private ConcernerRepository concernerRepository;
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
	///concerner-ajout-form/
	@GetMapping("/concerner-delete/{idSommet}/{idConcerner}")
	public ModelAndView concernerModif(@PathVariable int idSommet,
	@PathVariable int idConcerner) {
		concernerRepository.deleteConcerner(idSommet, idConcerner);
		if(concernerRepository.countSommet(idConcerner) == 0) {
			reserverRepository.deleteAllAbrisRando(idConcerner);
		}
		return new ModelAndView("redirect:/randonnees");
	}
	
	@PostMapping("/concerner-ajout-form/{idRandonnee}")
	public ModelAndView concernerAjout(@PathVariable int idRandonnee,
	@RequestParam(value="dateDebut", defaultValue="null") String dateDebut,
	@RequestParam(value="dateFin", defaultValue="null") String dateFin,
	@RequestParam(value="dateConcerner", defaultValue="null") String dateConcerner,
	@RequestParam(value="ajoutSommet", defaultValue="null") String ajoutSommet) throws ParseException {
		ModelAndView mav = new ModelAndView("redirect:/randonnees");
		String erreur = "";
		if(!isValid(dateConcerner, "yyyy-MM-dd")) {
			erreur += "Date Concern??e incorrecte <br>";
		} else {
			if(!isValid(dateDebut, "yyyy-MM-dd")) {
				erreur += "Date de d??but incorrecte <br>";
			} else {
				if(!isValid(dateFin, "yyyy-MM-dd")) {
					erreur += "Date de fin incorrecte <br>";
				} else {	
					if(dateConcerner.compareTo(dateFin)>0  || dateDebut.compareTo(dateConcerner)>0) {
						erreur += "Date sommet en dehors du planning de la randonn??e <br>";
					} else {
						if(!sommetRepository.existsById(Integer.valueOf(ajoutSommet))) {
							erreur += "Sommet Non Existant <br>";
						//verif si ??a existe pas d??j??
						} else if(concernerRepository.countConcerner(Integer.valueOf(ajoutSommet), idRandonnee) != 0){
							erreur += "Duo Sommet Randonn??e existant<br>";
						} else {
							System.out.println(Integer.valueOf(ajoutSommet)+","+idRandonnee+","+ dateConcerner);
							ConcernerModel concernerModel = new ConcernerModel();
							ConcernerKey concernerKey = new ConcernerKey();
							concernerKey.setCoderandonnees(idRandonnee);
							concernerKey.setCodesommets(Integer.valueOf(ajoutSommet));
							concernerModel.setDate_concerner(dateConcerner);
							concernerModel.setId(concernerKey);
							concernerModel.setRandonnees(randonneesRepository.findById(idRandonnee).get());
							concernerModel.setSommets(sommetRepository.findById(Integer.valueOf(ajoutSommet)).get());
							concernerRepository.save(concernerModel);
						}
					}
				}
			}
		}
		return new ModelAndView("redirect:/randonnees");
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
			erreur += "Date Concern??e incorrecte <br>";
		} else {
			if(!isValid(dateDebut, "yyyy-MM-dd")) {
				erreur += "Date de d??but incorrecte <br>";
			} else {
				if(!isValid(dateFin, "yyyy-MM-dd")) {
					erreur += "Date de fin incorrecte <br>";
				} else {	
					if(dateConcerner.compareTo(dateFin)>0  || dateDebut.compareTo(dateConcerner)>0) {
						erreur += "Date sommets en dehors du planning de la randonn??e <br>";
					} else {
							concernerRepository.updateConcerner1(idSommet, idConcerner, dateConcerner);
					}
				}
			}
		}
		return new ModelAndView("redirect:/randonnees");
	}
}
