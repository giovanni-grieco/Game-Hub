package it.uniroma3.siw.GameHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import it.uniroma3.siw.GameHub.model.WebUser;
import it.uniroma3.siw.GameHub.repository.WebUserRepository;

@Controller
public class WebUserController {
	@Autowired
	WebUserRepository webUserRepository;
	
	@GetMapping("/formNewWebUser")
	public String formNewWebUser(Model model) {
		model.addAttribute("webUser", new WebUser());
		return "formNewWebUser.html";
	}
	
	@GetMapping("/webUsers")
	public String webUsers(Model model) {
		return "webUsers.html";
	}
	
	@PostMapping("/webUsers")
	public String newWebUser(@ModelAttribute("webUser") WebUser wu, Model model){
		if(!webUserRepository.existsByUserEmail(wu.getUserEmail())) {
			model.addAttribute("webUser", wu);
			webUserRepository.save(wu);
			return "webUser.html";
		}else {
			model.addAttribute("messaggioErrore", "Utente già esistente");
			return "formNewWebUser.html";
		}
	}
	
	@GetMapping("/webUser/{webUser_id}")
	public String webUser(@PathVariable("webUser_id") Long id, Model model) {
		try {
			WebUser wu = webUserRepository.findById(id).get();
			model.addAttribute("webUser", wu);
		}catch(Exception e) {
			model.addAttribute("messaggioErrore", "L'utente non esiste");
		}
		return "webUser.html";
	}
}
