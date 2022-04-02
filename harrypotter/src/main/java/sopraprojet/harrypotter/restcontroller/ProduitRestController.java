package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.boutique.Produit;

import sopraprojet.harrypotter.service.ProduitService;

@RestController
@RequestMapping("/api/catalogue")
public class ProduitRestController {

	
	@Autowired
	private ProduitService produitService;
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("")
	public List<Produit> getAll() {
		return produitService.getAll();
	}
	

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
