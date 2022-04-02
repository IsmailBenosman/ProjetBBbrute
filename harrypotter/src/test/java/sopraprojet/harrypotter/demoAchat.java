//package sopraprojet.harrypotter;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import sopraprojet.harrypotter.boutique.Panier;
//import sopraprojet.harrypotter.boutique.Produit;
//import sopraprojet.harrypotter.compte.Compte;
//import sopraprojet.harrypotter.compte.Eleve;
//import sopraprojet.harrypotter.service.EleveService;
//import sopraprojet.harrypotter.service.PanierService;
//import sopraprojet.harrypotter.service.ProduitService;
//
//public class demoAchat {
//	@Autowired
//	static EleveService eleveService;
//	
//	
//	@Autowired
//	static ProduitService produitService;
//	@Autowired
//	static PanierService panierService;
//	
//	public static void main(String[] args) {
//		Compte connected = eleveService.getById(1);
//		Produit p1 = produitService.getById(1);
//		
//		Panier p = new Panier();
//		p.setArticles(p1);
//		p.setQuantite(1);
//		p.setCompte(connected);
//		
//		//Save ton panier (isAchat est encore à false)
//		panierService.save(p);
//		
//		//Quand on consulte le panier, 3 options :
//		
//		//1)
//		List<Panier>articlesDansLePanier = panierService.findPanierWithCompteDansLePanier(connected);
//		
//		
//		//Tu veux changer la quantitée
//		Panier panierQuOnVeutModifier = articlesDansLePanier.get(2);
//		
//		panierQuOnVeutModifier.setQuantite(3);
//		//Qaund on veut valider la nouvelle qte : 
//		panierService.save(p);
//		
//		
//		
//		
//		
//		//2) Soit tu veux virer l'article de ton panier => 
//		articlesDansLePanier = panierService.findPanierWithCompteDansLePanier(connected);
//		//Tu veux virer le 2e
//		Panier panierQuOnVeutDelete = articlesDansLePanier.get(2);
//		panierService.delete(panierQuOnVeutDelete.getId());
//		
//		//3 tu veux valider ton/tes achat() !
//		
//		for(Panier pa  :articlesDansLePanier) 
//		{
//			//On passe le boolean achat à true, ce qui veut dire que l'article ne doit plus apparaitre dans notre panier mais dans l"historique des achats
//			pa.setAchat(true);
//			
//			double nouveauSolde= connected.getSolde()-(pa.getArticle().getPrix()*pa.getQuantite());
//			//On decremente le solde actuel avec le prix * qte du produit
//			connected.setSolde(nouveauSolde);
//			panierService.save(pa);
//		}
//		
//		eleveService.save((Eleve) connected);
//		
//	}
//
//}
