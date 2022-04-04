package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.service.CompteService;

@RestController
@RequestMapping("/api/compte")
public class HomeRestController {

	@Autowired
	
	CompteService compteService; 
	@GetMapping("")
	public String hello() {
		return ("<h1>Hello</h1>");
	}

	@GetMapping("/admin")
	public List<Compte> homeAdmin() {
		return compteService.getAll();
	}

	@GetMapping("/eleve")
	public String eleve() {
		return ("<h1>Hello eleve</h1>");
	}

	@GetMapping("/prof")
	public String prof() {
		return ("<h1>Hello prof</h1>");
	}

}
