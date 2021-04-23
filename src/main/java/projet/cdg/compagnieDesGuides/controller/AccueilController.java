package projet.cdg.compagnieDesGuides.controller;

import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import projet.cdg.compagnieDesGuides.model.GuidesModel;
import projet.cdg.compagnieDesGuides.model.SommetsModel;
import projet.cdg.compagnieDesGuides.repository.GuidesRepository;
import projet.cdg.compagnieDesGuides.repository.RandonneesRepository;
import projet.cdg.compagnieDesGuides.repository.SommetsRepository;

@RestController
public class AccueilController {
	
	
	@Autowired
	private GuidesRepository guidesRepository;
	
	@Autowired                           
	private ApplicationContext context;  

	@RequestMapping("/")
	public ModelAndView all() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView connexion(@RequestParam(value="email", defaultValue="null") String email,
			@RequestParam(value="password", defaultValue="null") String password,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
			if(!email.contentEquals("null") && !password.contentEquals("null")) {
				
				GuidesModel guide = guidesRepository.findGuidesByMail(email);
				
				if(guide != null) {
					String mdpGuide = guide.getMotdepasse();
					if(mdpGuide.contentEquals(password)){
							HttpSession session = request.getSession();
							
							session.setAttribute("guide", guide);
			
							mav.setViewName("home");
							return mav;}
						else {
							mav.addObject("erreur","Mot de passe incorrect");
							mav.setViewName("home");
							return mav;
						}
				}
					else {
							mav.addObject("erreur","Aucun email correspondant");
							mav.setViewName("home");
							return mav;
						}
			}
			else {
					mav.addObject("erreur","Vous devez saisir tout les champs");    
					mav.setViewName("home");
					return mav;
				}
					
				
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		session.removeAttribute("guide");;
		
		mav.setViewName("home");
		return mav;

	}
}