package sopraprojet.harrypotter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.service.BoutiqueService;
import sopraprojet.harrypotter.service.ProduitService;

@SpringBootTest
class BoutiqueTest {

	
	
	@Autowired
	BoutiqueService boutiqueService;
	
	@Autowired
	ProduitService produitService;
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void CreationBoutiqueTest() {
		Boutique boutique = new Boutique(Categorie.Balais, "Balaiterie", "Sorry, je connais pas trop Harry Potter");
		boutiqueService.create(boutique);

	}
	
	@Disabled
	@Test
	void boutiqueservicetest() {
		assertNotNull(boutiqueService);
	}
	//@Disabled
	@Test
	@Transactional
	@Commit
	void CreationProduitTest() {
		Boutique boutique = new Boutique(Categorie.Boissons, "Bar", "Sorry, je connais toujours pas trop Harry Potter");
		Boutique boutique1=new Boutique(Categorie.Herboristerie,"L'apothicaire","37 chemin de traverse");
		
		boutiqueService.create(boutique);
		//produitService.create(produit);
	}
	@Disabled
	@Test
	void produitservicetest() {
		assertNotNull(produitService);
	}
}
