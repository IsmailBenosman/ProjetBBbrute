package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.exception.PanierException;
import sopraprojet.harrypotter.service.CompteService;
import sopraprojet.harrypotter.service.PanierService;

@RestController
@RequestMapping("/api/panier")
public class PanierRestController {

	@Autowired
	private CompteService compteService;

	@Autowired
	private PanierService panierService;
	
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("")
	public List<Panier> getAll() {
		return panierService.getAll();
	}

	@JsonView(JsonViews.Produit.class)
	@GetMapping("/{id}")
	public List<Panier> getAll(@PathVariable Integer id) {
		Compte c = compteService.getById(id);
		return panierService.findPanierWithCompteDanssLePanier(c);
	}

	@JsonView(JsonViews.Produit.class)
	@GetMapping("/historique/{id}")
	public List<Panier> getAllHistorique(@PathVariable Integer id) {
		Compte c = compteService.getById(id);
		return panierService.findPanierWithCompteWithHistorique(c);
	}

	@JsonView(JsonViews.Produit.class)
	@PutMapping("/{id}")
	public Panier update(@PathVariable Integer id, @Valid @RequestBody Panier panier, BindingResult br) {
		panier.setId(id);
		return createOrUpdate(panier, br);
	}

	private Panier createOrUpdate(Panier panier, BindingResult br) {
		if (br.hasErrors()) {
			throw new PanierException("Erreur");
		}
		return panierService.save(panier);
	}

	@JsonView(JsonViews.Produit.class)
	@GetMapping("/achat/validation")
	private Compte soldeCheck(@PathVariable Integer id, @Valid @RequestBody Panier panier) {
		Compte c = compteService.getById(id);
		List<Panier> articlesPanier = panierService.findPanierWithCompteDanssLePanier(c);
		for (Panier p : articlesPanier) {
			if (c.getSolde() - (p.getArticles().getPrix() * p.getQuantite()) >= c.getSolde()) {
				return validationPanier(id, panier);
			} else {
				throw new PanierException("Erreur: Solde insuffisant");
			}
		}
		return compteService.save(c);
	}

	private Compte validationPanier(@PathVariable Integer id, @Valid @RequestBody Panier panier) {
		Compte c = compteService.getById(id);
		List<Panier> articlesPanier = panierService.findPanierWithCompteDanssLePanier(c);
		for (Panier p : articlesPanier) {
			double newSolde = c.getSolde() - (p.getArticles().getPrix() * p.getQuantite());
			c.setSolde(newSolde);
			panierService.save(p);
		}
		return compteService.save(c);
	}
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable Integer id) {
		panierService.deleteById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Panier create(@Valid @RequestBody Panier panier, BindingResult br) {
		return createOrUpdate(panier, br);
	}
}
