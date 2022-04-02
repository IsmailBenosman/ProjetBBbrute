package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.compte.Compte;
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
	@GetMapping("/{id}")
	public List<Panier> getAll(@PathVariable("id") Integer id) {
		Compte c = compteService.getById(id);
		return panierService.findPanierWithCompteDanssLePanier(c);
	}

	@JsonView(JsonViews.Produit.class)
	@GetMapping("/historique/{id}")
	public List<Panier> getAllHistorique(@PathVariable("id") Integer id) {
		Compte c = compteService.getById(id);
		return panierService.findPanierWithCompteWithHistorique(c);
	}

	@JsonView(JsonViews.Common.class)
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


	private Compte validationPanier(@PathVariable Integer id, @Valid @RequestBody Panier panier) {
		Compte c = compteService.getById(id);
		List<Panier> articlesPanier = panierService.findPanierWithCompteDanssLePanier(c);
		for (Panier p : articlesPanier) {
			if (c.getSolde() - (p.getArticles().getPrix() * p.getQuantite()) >= c.getSolde()) {
				p.setAchat(true);
				double newSolde = c.getSolde() - (p.getArticles().getPrix() * p.getQuantite());
				c.setSolde(newSolde);
				panierService.save(p);
			} else {
				throw new PanierException("Erreur: Solde insuffisant");
			}
		}
		return compteService.save(c);
	}

}
