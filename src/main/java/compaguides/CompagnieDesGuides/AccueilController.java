package compaguides.CompagnieDesGuides;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

@RestController
public class AccueilController {

	//@Autowired // Récupérer le Bean Java employesRepository auto-généré par Spring
	//private EmployesRepository employesRepository;
	
	//Récupérer le contexte de l'application pour accéder à tous les beans auto-générés
	@Autowired
	private ApplicationContext context;
	
	@RequestMapping({"/", "index"})
	public ModelAndView all() {
		System.out.println("rando");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

}
