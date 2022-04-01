package sopraprojet.harrypotter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.service.BoutiqueService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.PanierService;
import sopraprojet.harrypotter.service.ProduitService;


@SpringBootTest
class AchatBoutiqueTest {

	
	// ne marche pas, je fais des modifs, le lancez pas
	@Autowired
	EleveService eleveService;
	
	@Autowired
	ProduitService produitService;
	
	@Autowired
	BoutiqueService boutiqueService;
	
	@Autowired
	PanierService panierService;
	
	@Disabled
	@Test
	@Transactional
	@Commit
//	@Rollback
	void AjoutArticlePaneirTest() {
		
		Maison m1= new Maison("Serdaigle");
		Eleve e1 = new Eleve("Test", "Test", "Test", "Test", LocalDate.parse("1997-03-18"), 0,m1);
		
		Panier panier= new Panier();
		
		Boutique boutique = new Boutique(Categorie.Animaux, "Animalerie", "Sorry");
		
		Produit produit = new Produit(boutique, "Hibou", 50.65 ,"Elle s'appelle Hedwige");
		Produit produit1 = new Produit(boutique, "Rat", 10.25 ,"Il s'appelle Croutard");
		Produit produit2 = new Produit(boutique, "Crapaud", 0 ,"Il s'appelle Trevor");
		
		List<Produit> produits =new ArrayList();
		produit.setPanier(panier);
		produit1.setPanier(panier);
		produit2.setPanier(panier);
		Collections.addAll(produits, produit,produit1,produit2);
		panier.setArticles(produits);
		panier.setCompte(e1);
		
		eleveService.create(e1);
		boutiqueService.create(boutique);
		produitService.create(produit);
		produitService.create(produit1);
		produitService.create(produit2);
		
		System.out.println(produits);
		System.out.println(panier);

	}

	}

