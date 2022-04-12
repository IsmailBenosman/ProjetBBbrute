package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.boutique.Livraison;
import sopraprojet.harrypotter.service.LivraisonService;

@RestController
@RequestMapping("/api/livraisons")
@CrossOrigin(origins="*")
public class LivraisonRestController {


	@Autowired
	private LivraisonService livraisonService;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Livraison> getAll() {
		return livraisonService.getAll();
	}
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Livraison getById(@PathVariable Integer id) {
		return livraisonService.getById(id);
	}

		

}
