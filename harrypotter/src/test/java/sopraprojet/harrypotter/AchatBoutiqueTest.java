package sopraprojet.harrypotter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.service.BoutiqueService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.MaisonService;
import sopraprojet.harrypotter.service.PanierService;
import sopraprojet.harrypotter.service.ProduitService;


@SpringBootTest
class AchatBoutiqueTest {

	@Autowired
	EleveService eleveService;
	@Autowired
	MaisonService maisonService;
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
	void AjoutArticlePanierTest() {
		
		Maison m1= new Maison("Serdaigle");
		Eleve e1 = new Eleve("Test", "Test", "Test", "Test", LocalDate.parse("1997-03-18"), 0,m1);
		
		Panier panier= new Panier();
		Panier panier1= new Panier();
		Boutique boutique = new Boutique(Categorie.Animaux, "Animalerie", "Sorry");
		
		Produit produit = new Produit(boutique, "Hibou", 50.65 ,"Elle s'appelle Hedwige");
		Produit produit1 = new Produit(boutique, "Rat", 10.25 ,"Il s'appelle Croutard");
		Produit produit2 = new Produit(boutique, "Crapaud", 0 ,"Il s'appelle Trevor");
		
		panier.setArticles(produit);
		panier.setQuantite(3);
		panier1.setArticles(produit1);
		panier1.setQuantite(2);
		
		panier.setCompte(e1);
		panier1.setCompte(e1);
		
		maisonService.create(m1);
		eleveService.create(e1);
		panierService.create(panier);
		panierService.create(panier1);
		boutiqueService.create(boutique);
		produitService.create(produit);
		produitService.create(produit1);
		produitService.create(produit2);
		assertNotNull(panierService);
		System.out.println(panier);

	}	
	
	@Disabled
	@Test
	@Transactional
	@Commit
//	@Rollback
	void ModifPanierTest() {
		
		Panier panierNew= panierService.getById(1);
		panierNew.setQuantite(7);
		panierNew.setArticles(produitService.getById(3));
		panierNew.setCompte(eleveService.getById(1));
		panierService.save(panierNew);
		
	}
	
//	@Disabled
	@Test
	@Transactional
	@Commit
//	@Rollback
	void SupprimerArticlePanierTest() {

		panierService.delete(panierService.getById(1));
		
	}
	

	}

