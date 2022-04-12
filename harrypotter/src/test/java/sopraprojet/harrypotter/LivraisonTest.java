package sopraprojet.harrypotter;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Livraison;
import sopraprojet.harrypotter.service.BoutiqueService;
import sopraprojet.harrypotter.service.LivraisonService;


@SpringBootTest
class LivraisonTest {

	@Autowired
	LivraisonService livraisonService;
	
	@Autowired
	BoutiqueService boutiqueService;
	@Disabled
	@Test
	@Transactional
	@Commit
	void CreationLivraisonTest() {
		List<Livraison> modes = new ArrayList();
		Livraison livraison = new Livraison("LaPoste", 0.50, "Livraison sous 14 jours");
		Livraison livraison1 = new Livraison("Hiboux", 5.20, "Livraison sous 7 jours");
		Livraison livraison2= new Livraison("Dragon", 7.80, "Livraison sous 3 jours");
		Livraison livraison3 = new Livraison("Elfe", 10.99, "Livraison dans l'heure");
		modes.add(livraison);
		modes.add(livraison1);
		modes.add(livraison2);
		modes.add(livraison3);
		
		Boutique boutique = new Boutique(Categorie.Confiserie, "Confiserie", "rue JeSaisPas");
		boutique.setModeLivraison(modes);
		
//		livraisonService.create(livraison);
//		livraisonService.create(livraison1);
//		livraisonService.create(livraison2);
//		livraisonService.create(livraison3);
		boutiqueService.create(boutique);
		System.out.println(modes);

	}

}
