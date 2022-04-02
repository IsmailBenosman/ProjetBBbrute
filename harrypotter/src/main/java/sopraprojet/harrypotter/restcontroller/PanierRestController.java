package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.PanierService;

@RestController
@RequestMapping("/api/panier")
public class PanierRestController {

	

	@Autowired
	private EleveService eleveService;
	
	
	@Autowired
	private PanierService panierService;
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("/{id}")
	public List<Panier> getAll(@PathVariable("id") Integer id) {
		Compte c = eleveService.getById(id);
		return  panierService.findPanierWithCompteDanssLePanier(c);
	}
	
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("/historique/{id}")
	public List<Panier> getAllHistorique(@PathVariable("id") Integer id) {
		Compte c = eleveService.getById(id);
		return  panierService.findPanierWithCompteHistorique(c);
	}
	
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Panier create(@Valid @RequestBody Panier panier, BindingResult br) {
		return createOrUpdate(panier, br);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Panier update(@PathVariable Integer id, @Valid @RequestBody Panier panier, BindingResult br) {
		panier.setId(id);
		return createOrUpdate(panier, br);
	}

	private Panier createOrUpdate(Panier panier, BindingResult br) {
		if (br.hasErrors()) {
			//throw new PanierException();
		}
		return panierService.save(panier);
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
