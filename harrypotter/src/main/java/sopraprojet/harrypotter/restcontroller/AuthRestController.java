package sopraprojet.harrypotter.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Compte;

@RestController
@RequestMapping("/api/connexion")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@JsonView(JsonViews.Compte.class)
	@GetMapping("")
	public Compte auth(@AuthenticationPrincipal Compte compte) {
		return compte;
	}
}
