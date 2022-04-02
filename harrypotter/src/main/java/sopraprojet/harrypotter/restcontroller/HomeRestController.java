package sopraprojet.harrypotter.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;

@RestController
public class HomeRestController {

	@GetMapping("/")
	public String hello() {
		return ("<h1>Hello</h1>");
	}

	@GetMapping("/admin")
	public String homeAdmin() {
		return ("<h1>Hello admin</h1>");
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
