package sopraprojet.harrypotter.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HarrypotterRestController {



	@GetMapping("/api/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/api/prof")
	public String prof() {
		return "prof";
	}
	
	@GetMapping("/api/eleve")
	public String eleve() {
		return "eleve";
	}

}
