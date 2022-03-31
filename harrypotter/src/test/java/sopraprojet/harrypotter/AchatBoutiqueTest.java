package sopraprojet.harrypotter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.service.BoutiqueService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.ProduitService;


@SpringBootTest
class AchatBoutiqueTest {

	@Autowired
	EleveService eleveService;
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	BoutiqueService boutiqueService;
	
	
	@Test
	@Transactional
	@Commit
//	@Rollback
	void CreationEventEleveTest() {
		
		List<Produit> produits = new ArrayList();
		Boutique boutique = new Boutique(Categorie.Animaux, "Animalerie", "Sorry");
		Produit produit = new Produit(boutique, "Hibou", 50.65 ,"Elle s'appelle Hedwige");
		Produit produit1 = new Produit(boutique, "Rat", 10.25 ,"Il s'appelle Croutard");
		Produit produit2 = new Produit(boutique, "Crapaud", 0 ,"Il s'appelle Trevor");
		produits.add(produit2);
		produits.add(produit1);
		produits.add(produit);
		
		Eleve e1 = new Eleve("Test", "Test", "Test", "Test", LocalDate.parse("1997-03-18"), 0,"Serdaigle");
		
		e1.setPanier(produits);
		
		eleveService.create(e1);
		boutiqueService.create(boutique);
		produitService.create(produit);
		produitService.create(produit1);
		produitService.create(produit2);
		
		System.out.println(produits);

	}

}
