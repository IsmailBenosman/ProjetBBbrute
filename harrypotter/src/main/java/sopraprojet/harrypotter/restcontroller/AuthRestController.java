package sopraprojet.harrypotter.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sopraprojet.harrypotter.compte.Compte;

@RestController
@RequestMapping("/api/connexion")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@GetMapping("")
	public String auth(@AuthenticationPrincipal Compte compte) {
		return compte.getClass().getSimpleName().toLowerCase();
	}
}
