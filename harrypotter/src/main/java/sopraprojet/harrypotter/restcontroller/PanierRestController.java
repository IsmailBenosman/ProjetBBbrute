//
//package sopraprojet.harrypotter.restcontroller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import
//org.springframework.http.HttpStatus;
//import
//org.springframework.validation.BindingResult;
//import
//org.springframework.web.bind.annotation.CrossOrigin;
//import
//org.springframework.web.bind.annotation.DeleteMapping;
//import
//org.springframework.web.bind.annotation.GetMapping;
//import
//org.springframework.web.bind.annotation.PathVariable;
//import
//org.springframework.web.bind.annotation.PostMapping;
//import
//org.springframework.web.bind.annotation.PutMapping;
//import
//org.springframework.web.bind.annotation.RequestBody;
//import
//org.springframework.web.bind.annotation.RequestMapping;
//import
//org.springframework.web.bind.annotation.ResponseStatus;
//import
//org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.annotation.JsonView;
//
//import sopraprojet.harrypotter.Json.JsonViews;
//import sopraprojet.harrypotter.boutique.Panier;
//import sopraprojet.harrypotter.boutique.Produit;
//import sopraprojet.harrypotter.compte.Compte;
//import sopraprojet.harrypotter.exception.PanierException;
//import sopraprojet.harrypotter.service.CompteService;
//import sopraprojet.harrypotter.service.PanierService;
//
//
//@RestController
//
//@RequestMapping("/api/historique")
//
//@CrossOrigin(origins="*") public class PanierRestController {
//
//	@Autowired private CompteService compteService;
//
//	@Autowired private PanierService panierService;
//
//	@JsonView(JsonViews.Common.class)
//
//	@GetMapping("") public List<Panier> getAll() { 
//		return panierService.getAll();
//	}
////
////	@JsonView(JsonViews.Common.class)
//
////	@GetMapping("/compte/{id}") public List<Panier> getById(@PathVariable Integer id) 
////	{ Compte c = compteService.getById(id); 
////	return panierService.findPanierWithCompteDanssLePanier(c); }
////	
////
////	@JsonView(JsonViews.Common.class)
////
////	@GetMapping("/historique/compte/{id}") public List<Panier>
////	getAllHistorique(@PathVariable Integer id) { Compte c =
////	compteService.getById(id); return
////			panierService.findPanierWithCompteWithHistorique(c); }
//
//	@JsonView(JsonViews.PanierWithCompte.class)
//	@PutMapping("/{id}") public Panier update(@PathVariable Integer
//			id, @Valid @RequestBody Panier panier, BindingResult br) { panier.setId(id);
//			return createOrUpdate(panier, br); }
//
//	private Panier createOrUpdate(Panier panier, BindingResult br) {
//		System.out.println(panier); System.out.println(panier.getCompte());
//		System.out.println(panier.getArticles()); if (br.hasErrors()) { throw new
//			PanierException("Erreur"); } return panierService.save(panier); }
//
//
//	@JsonView(JsonViews.Common.class)
//
////	@GetMapping("/validation/compte/{id}") private Compte
////	soldeCheck(@PathVariable Integer id, @Valid @RequestBody Panier panier) {
////		Compte c = compteService.getById(id); List<Panier> articlesPanier =
////				panierService.findPanierWithCompteDanssLePanier(c); double totalPanier = 0;
////				for (Panier p : articlesPanier) { totalPanier+=p.getArticles().getPrix() *
////						p.getQuantite(); }
////
////				if(c.getSolde()>=totalPanier) { for (Panier p : articlesPanier) {
////					p.setAchat(true); p.setDateAchat(LocalDateTime.now()); panierService.save(p);
////				} c.setSolde(c.getSolde()-totalPanier); compteService.save(c); } else {
////					System.out.println("Modifier : Solde insuffisant"); } return
////							compteService.save(c); }
//
//	@ResponseStatus(code = HttpStatus.NO_CONTENT)
//
//	@DeleteMapping("/{id}") public void delete(@PathVariable Integer id) {
//		panierService.deleteById(id); }
//
//	// @PostMapping("/ajoutproduit/{id}") // @JsonView(JsonViews.Common.class) 
//	//	public List<Panier> ajoutProduit(@PathVariable Integer id, @Valid @RequestBody Produit produit) { 
//	// Compte compte =compteService.getByIdWithPanier(id); 
//	// List<Panier> listepanier= compte.getPanier(); 
//	// Panier panier= new Panier(); 
//	//	panier.setArticles(produit); 
//	// listepanier.add(panier); 
//	// compte.setPanier(listepanier); 
//	// panierService.save(panier); 
//	//	compteService.save(compte); 
//	// return listepanier; 
//	// }
//
//
//		@JsonView(JsonViews.Common.class)
//		@PostMapping("/{id}")
//		@ResponseStatus(code = HttpStatus.CREATED) public Panier create(@PathVariable
//				Integer id,@Valid @RequestBody Panier panier, BindingResult br) { Compte
//			compte = compteService.getById(id); panier.setCompte(compte); return
//					createOrUpdate(panier, br); } }
