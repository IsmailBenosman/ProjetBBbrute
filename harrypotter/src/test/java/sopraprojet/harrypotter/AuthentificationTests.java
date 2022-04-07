package sopraprojet.harrypotter;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.compte.Admin;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.repositories.BoutiqueRepository;
import sopraprojet.harrypotter.repositories.ProfRepository;
import sopraprojet.harrypotter.service.AdminService;
import sopraprojet.harrypotter.service.BoutiqueService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.MaisonService;
import sopraprojet.harrypotter.service.ProduitService;
import sopraprojet.harrypotter.service.ProfService;

@SpringBootTest
class AuthentificationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Autowired
	private EleveService eService;
	@Autowired
	private ProfService pService;
	@Autowired
	private AdminService aService;
	@Autowired
	private MaisonService mService;
	@Autowired
	private ProfRepository pRepo;
	@Autowired
	private ProduitService produitS;
	@Autowired
	private BoutiqueService boutiqueS;
	@Autowired
	private BoutiqueRepository boutiqueR;


	@Disabled
	@Transactional
	@Commit
	void createEleve() {
		
		Maison m1 = new Maison("Griffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Serdaigle");
		Maison m4 = new Maison("Poufsouffle");
		mService.save(m1);
		mService.save(m2);
		mService.save(m3);
		mService.save(m4);
		Eleve e1 = new Eleve("Ismail", "Benosman", "isma", passwordEncoder.encode("isma"), null, 0, m4);
		Eleve e2 = new Eleve("Ahmed", "Skalli", "ska", passwordEncoder.encode("ska"), null, 0, m2);
		Eleve e3 = new Eleve("Mohamed", "Belarbi", "momo", passwordEncoder.encode("momo"), null, 0, m1);
		Eleve e4 = new Eleve("Nadir", "Çaoui", "nadir", passwordEncoder.encode("nadir"), null, 0, m3);
				
		eService.create(e1);
		eService.create(e2);
		eService.create(e3);
		eService.create(e4);
	}
	
	@Test
	@Transactional
	@Commit
	void createbd() {
		
		Maison m1 = new Maison("Griffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Serdaigle");
		Maison m4 = new Maison("Poufsouffle");
		mService.create(m1);
		mService.create(m2);
		mService.create(m3);
		mService.create(m4);
		
		Eleve e1 = new Eleve("Robin", "Pierson", "Rob", passwordEncoder.encode("Rob"), null, 0, m1);
		eService.create(e1);
		
		Eleve e2 = new Eleve("Michel", "Vong", "Mich", passwordEncoder.encode("Mich"), null, 0, m3);
		eService.create(e2);
		
		Eleve e3 = new Eleve("Pauline", "Baccelli", "Popo", passwordEncoder.encode("Popo"), null, 0, m4);
		eService.create(e3);
		
		Eleve e4 = new Eleve("Anne", "Tournillon", "Anne", passwordEncoder.encode("Anne"), null, 0, m2);
		eService.create(e4);
		
		
		Prof p1 = new Prof("Pinel","Matthieu", "Matthieu",passwordEncoder.encode("Matthieu"), LocalDate.parse("1998-02-23"),10000,m1);
		pRepo.save(p1);
		
		Prof p2 = new Prof("Benosman","Ismail", "Ismail",passwordEncoder.encode("Ismail"), LocalDate.parse("1996-02-16"),10000,m4);
		pRepo.save(p2);
		
		Prof p3 = new Prof("Ye","Elisabeth", "Elisabeth",passwordEncoder.encode("Elisabeth"), LocalDate.parse("1996-10-15"),10000,m3);
		pRepo.save(p3);
		
		Prof p4 = new Prof("Gozlan","Olivier", "Olivier",passwordEncoder.encode("Olivier"), LocalDate.parse("1996-10-15"),10000,m2);
		pRepo.save(p4);
		
		
		Admin a1 = new Admin("Abid","Jordan", "Jordan",passwordEncoder.encode("Jordan"), LocalDate.parse("1998-02-23"),10000,m2);
		aService.create(a1);
		
		Boutique b1= new Boutique(Categorie.Balais,"Magasin d’accessoires de Quidditch "," 24 chemin de traverse" );
		Boutique b2= new Boutique(Categorie.Herboristerie,"L’apothicaire "," 37 chemin de traverse" );
		Boutique b3= new Boutique(Categorie.Bar,"Le Chaudron Baveur "," 1 chemin de traverse" );
		Boutique b4= new Boutique(Categorie.Librairie,"Fleury et Bott "," 13 chemin de traverse" );
		Boutique b5= new Boutique(Categorie.Banque,"Gringotts "," 44 chemin de traverse" );
		Boutique b6= new Boutique(Categorie.Animaux,"Ménagerie magique "," Le chemin de traverse" );
		Boutique b7= new Boutique(Categorie.Baguettes,"Ollivander"," 62 chemin de traverse" );
		Boutique b8= new Boutique(Categorie.Magie," Weasley & Weasley, Farces pour sorciers facétieux", " 93 chemin de traverse" );
		Boutique b9= new Boutique(Categorie.Magie,"Barjow et Beurk", " L'allée des embrumes" ); 
		Boutique b10= new Boutique(Categorie.Boissons,"Florian Fortarôme ", "17 chemin de traverse" );
		
		Boutique b11= new Boutique(Categorie.Animaux,"Eeylops, Au Royaume du Hibou"," 8 chemin de traverse" );
		Boutique b12= new Boutique(Categorie.Vetements,"Wiseacres Équipements pour Sorciers "," 87 chemin de traverse" );
		Boutique b13= new Boutique(Categorie.Vetements,"Wiseacres Équipements pour Sorciers "," 76 chemin de traverse" );
		Boutique b14= new Boutique(Categorie.Vetements,"Madame Guipure, prêt-à-porter pour mages et sorciers "," 29 chemin de traverse" );
		Boutique b15= new Boutique(Categorie.Vetements,"Tissard et Brodette"," 57 chemin de traverse" );
		Boutique b16= new Boutique(Categorie.Librairie,"Obscurus Books "," 3 chemin de traverse" );
		
		boutiqueS.create(b1);
		boutiqueS.create(b2);
		boutiqueS.create(b3);
		boutiqueS.create(b4);
		boutiqueS.create(b5);
		boutiqueS.create(b6);
		boutiqueS.create(b7);
		boutiqueS.create(b8);
		boutiqueS.create(b9);
		boutiqueS.create(b10);
		boutiqueS.create(b11);
		boutiqueS.create(b12);
		boutiqueS.create(b14);
		boutiqueS.create(b15);
		boutiqueS.create(b16);
		
		Produit produit1= new Produit(b1,"Balétoile XXI", 200.0, "Le Balétoile XXI est un balai de course. Il est utilisé par l'équipe de Quidditch des États-Unis lors de la Coupe du Monde de Quidditch de 2014.");
		Produit produit2= new Produit(b1,"La Bombe bleue", 200.0, "La Bombe bleue  est un balai familial sûr, stable et équipé d'une sirène antivol");
		Produit produit3= new Produit(b1,"Le Brossdur 1", 200.0, "Le Brossdur 1 est un modèle de balais de course, produit en 1926 par la Compagnie des balais Brossdur.");
		Produit produit4= new Produit(b1,"Le Brossdur 2", 200.0, "Le Brossdur 2 est un modèle de balais de course, produit en 1934 par la Compagnie des balais Brossdur.");
		Produit produit5= new Produit(b1,"Le Brossdur 3", 200.0, "Le Brossdur 3 est un modèle de balais de course, produit en 1937 par la Compagnie des balais Brossdur.");
		Produit produit6= new Produit(b1,"Le Brossdur 5", 200.0, "Le Brossdur 5 , aussi appelé Astiqueur 5, est un modèle de balais de course, produit par la Compagnie des balais Brossdur. Les jumeaux Weasley en étaient propriétaires");
		Produit produit7= new Produit(b1,"Le Brossdur 6", 200.0, "Le Brossdur 6 est un modèle de balais de course, produit par la Compagnie des Balais Brossdur.");
		Produit produit8= new Produit(b1,"Le Brossdur 7", 200.0, "Le Brossdur 7 est un modèle de balais de course, produit par la Compagnie des Balais Brossdur.");
		Produit produit9= new Produit(b1,"Le Brossdur 11", 200.0, "Le Brossdur 11 (  Angl.  Cleansweep Eleven ) est un modèle de balais de course, produit par la Compagnie des balais Brossdur, capable de passer de 0 à 100 km/h en dix secondes.");
		Produit produit10= new Produit(b1,"Le Comète 140", 200.0, "Le Comète 140 est un modèle de balais de course, produit par la Compagnie de la comète. Il doit le chiffre de son nom aux cent quarante exemplaires testés avant d'en lancer sa commercialisation.");
		Produit produit11= new Produit(b1,"Le Comète 180", 200.0, "Le Comète 180 est un modèle de balais de course, produit en 1938 par la Compagnie de la comète. Il est le rival du Brossdur 2 et du Brossdur 3.");
		Produit produit12= new Produit(b1,"Le Comète 260", 200.0, "Le Comète 260 est un modèle de balais de course, produit par la Compagnie de la comète.");
		Produit produit13= new Produit(b1,"Le Comète 290", 200.0, "Le Comète 290 est un modèle de balais de course, produit par la Compagnie de la comète.");
		Produit produit14= new Produit(b1,"L'Éclair de Feu", 200.0, "L'Éclair de Feu est un balai volant sorti en 1993. C'est le balai le plus rapide au monde.");
		Produit produit15= new Produit(b1,"L'Éclair de Feu Suprême", 200.0, "L'Éclair de Feu Suprême est un balai de course. Il est utilisé par l'équipe de Quidditch de Bulgarie lors de la Coupe du Monde de Quidditch de 2014.[1]");
		Produit produit16= new Produit(b1,"L'Étoile filante", 200.0, "l'Étoile filante est produite en 1955 par la Compagnie des balais universels. Il s'agit alors du balai de course le moins cher du marché.");
		Produit produit17= new Produit(b1,"Le Flèche d'Argent", 200.0, "Le Flèche d'Argent est un précurseur du balai de course et atteint des vitesses très supérieures au Lancechêne 79 et au Friselune.");
		Produit produit18= new Produit(b1,"Le Feuopoudre", 200.0, "Le Feuopoudre  est un modèle de balai de course, produit à partir de 1940 par la Compagnie Ellerby et Spudmore. Bien qu'étant un modèle très résistant, sa vitesse l'empêche de rivaliser avec les deux grandes marques de l'époque : Brossdur et Comète.");
		Produit produit19= new Produit(b1,"Le Friselune", 200.0, "Le Friselune a représenté un bond en avant dans la construction des balais et, pendant longtemps, il fut très demandé par les joueurs de Quidditch. Son principal avantage était sa capacité à atteindre des altitudes importantes tout en restant contrôlable. ");
		Produit produit20= new Produit(b1,"Le Lancechêne 79", 200.0, "Le Lancechêne 79 est nommé ainsi en référence à l'année de sa création, 1879. Il s'agit d'un balai conçu pour les vols d'endurance et la résistance aux vents violents. C'est maintenant un balai de collection très recherché");
		Produit produit21= new Produit(b1,"Le MancheviF", 200.0, "Le Manchevif est un modèle de balai de course, produit en 1952 par la Compagnie Ellerby et Spudmore. Bien qu'étant plus rapide que son prédécesseur, le Feuopoudre, il perd de la puissance en montée.");
		Produit produit22= new Produit(b1,"Le Margotin 90", 200.0, "Le Margotin 90 est un modèle de balais de course, produit pour la première fois en 1990 par la compagnie Flyte et Barker. Ce balai de course est doté de gadgets, tels qu'un correcteur de trajectoire ou bien encore d'un sifflet d'alarme.");
		Produit produit23= new Produit(b1,"Le Nimbus 1001", 200.0, "Le Nimbus 1001 est un modèle de balais de course, produit par la Société des balais de course Nimbus. Successeur du Nimbus 1000, il a permis à la société de demeurer au premier rang.");
		Produit produit24= new Produit(b1,"Le Nimbus 1500", 200.0, "Le Nimbus 1500 est un modèle de balais de course, produit par la Société des balais de course Nimbus. Il a permis à la société de demeurer au premier rang.");
		Produit produit25= new Produit(b1,"Le Nimbus 1700", 200.0, "Le Nimbus 1700 est un modèle de balais de course, produit par la Société des balais de course Nimbus. Il a permis à la société de demeurer au premier rang.");
		Produit produit26= new Produit(b1,"Le Nimbus 2000", 200.0, "Le Nimbus 2000 est un balai de course, le plus rapide des balais à sa sortie en 1991. L'année suivante, le Nimbus 2001 fut commercialisé et détrôna son frère.");
		Produit produit27= new Produit(b1,"Le Nimbus 2001", 200.0, "Le Nimbus 2001 est le successeur du Nimbus 2000 en tant que balai de course. Il est le plus rapide des balais jusqu'à la sortie de l'Éclair de Feu l'année suivante, en 1993.");
		Produit produit28= new Produit(b1,"Le Varápidos", 200.0, "Le Varápidos est un balai de course. Il est utilisé par l'équipe de Quidditch du Brésil lors de la Coupe du Monde de Quidditch de 2014.");
		Produit produit29= new Produit(b1,"Le Yajirushi", 200.0, "Le Yajirushi est un balai de course. Il est utilisé par l'équipe de Quidditch du Japon lors de la Coupe du Monde de Quidditch de 2014. Il a été révélé pour la première fois au cours de ce tournoi.");
		Produit produit30= new Produit(b6,"Le Boursouf" ,200, "Le Boursouf est un charognard qui mange n'importe quoi avec sa longue langue extensible et notamment les restes de repas ou les araignées, mais il apprécie plus particulièrement les crottes de nez des sorciers,");
		Produit produit31= new Produit(b6,"Le Boursouflet" ,200, "On dit du Boursouflet, qu'il est adorable, mignon et qu'il donne envie de le caresser. Les Boursouflets peuvent rouler sur eux-mêmes, émettre des cris aigus...");
		Produit produit32= new Produit(b6,"Le Chat Blanc" ,9, "Le chat blanc a souvent des beaux yeux bleus qui créent un contraste saisissant avec sa robe d'un blanc neige.");
		Produit produit33= new Produit(b6,"Le Chat Tigré" ,9, "Le chat tigré est facilement reconnaissable grâce à sa robe rayée de couleur grise, marron ou rousse. Il est aussi appelé chat de gouttière.");
		Produit produit34= new Produit(b6,"Le Chat Noir" ,9, "Le chat noir est un animal de compagnie fidèle et agréable.");
		Produit produit35= new Produit(b6,"Le Chat Roux" ,9, "Le chat roux est un magnifique chat roux taché de noir. Il est en vente à la Ménagerie magique pour neuf Gallions");
		Produit produit36= new Produit(b6,"Le Chat Siamois" ,11, "Avec ses magnifiques yeux perçants, sa silhouette fine et sa tête triangulaire, le chat siamois est considéré par certains comme la plus belle race de félins.");
		Produit produit37= new Produit(b6,"La Chauve-Souris" ,5, "La chauve-souris est un animal non magique. Elle peut servir de décoration seule ou en groupe et son foie entre dans la composition de certaines potions");
		Produit produit38= new Produit(b6,"Crapaud violet géant" ,5, "Le crapaud violet géant est un animal friand de mouches mortes et autres insectes.");
		Produit produit39= new Produit(b6,"Le Crabe de Feu" ,5, "Le Crabe de Feu  malgré son nom ne ressemble non pas à un crabe mais à une tortue dont la carapace est incrustée de pierres précieuses.");
		Produit produit40= new Produit(b6,"Le Fléreur" ,5, "Le Fléreur, également appelé Kneazle, est une petite créature poilue, proche du chat, connue pour son intelligence et sa clairvoyance. Originaire de Grande-Bretagne, l'animal est aujourd'hui présent dans le monde entier.");
		Produit produit41= new Produit(b11,"La chouette des bois" ,10, "La chouette des bois possède une vision binoculaire ainsi qu'une audition directionnelle exceptionnelle. Ces atouts font d'elle un redoutable prédateur nocturne. Elle se nourrit essentiellement de petits rongeurs et de mulots.");
		Produit produit42= new Produit(b11,"La chouette effraie" ,10, "La chouette effraie est très répandue en Europe. C'est un oiseau qui possède une ouïe très développée.");
		Produit produit43= new Produit(b11,"La chouette hulotte" ,10, "La chouette hulotte a une ouïe très développée. Le mâle et la femelle communiquent en hululant longuement.");
		Produit produit44= new Produit(b11,"houette lapone" ,10, "Errol (qui appartient à la famille Weasley ) est une chouette lapone.");
		Produit produit45= new Produit(b11,"Le Grand-duc" ,10, "Le Grand-duc fait parti des animaux de compagnie dans le monde des sorciers.");
		Produit produit46= new Produit(b11,"Le petit-duc" ,15, "Le petit-duc est un oiseau extrêmement agile qui se nourrit de lapins, de mulots, de rats, de souris et de reptiles.");
		Produit produit47= new Produit(b6,"Lapin" ,10, "Les lapins sont des animaux de compagnie dans le monde des sorciers aussi bien que dans le monde des Moldus.");
		Produit produit48= new Produit(b6,"Le Musard" ,10, "Le Musard est un escargot géant qui change de couleur toutes les heures.");
		Produit produit49= new Produit(b6,"Le Niffleur" ,10, "Le Niffleur est une petite créature à la fourrure noire qui a une prédilection pour tout ce qui brille.");
		Produit produit50= new Produit(b6,"Le rat noir" ,10, "Le rat noir est apparemment plus intelligent que les autres rats.");
		Produit produit51= new Produit(b6,"Le rat gris" ,10, "C'est la variété de rat à laquelle Croûtard appartient.");
		Produit produit52= new Produit(b6,"Le triton à double queue" ,10, "Le triton à double queue est un animal de compagnie des sorciers.");
		Produit produit53= new Produit(b7,"Baguette de Chadwick Boot" ,10, "Frêne épineux, corne de serpent cordnu");
		/*
		 * Produit produit54= new Produit(b7,"Baguette de W " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit55= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit56= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit57= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit58= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit59= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit60= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit61= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers."); Produit
		 * produit62= new Produit(b7,"Baguette de " ,10,
		 * "Le triton à double queue est un animal de compagnie des sorciers.");
		 */
		produitS.save(produit1);
		produitS.save(produit2);
		produitS.save(produit3);
		produitS.save(produit4);
		produitS.save(produit4);
		produitS.save(produit5);
		produitS.save(produit6);
		produitS.save(produit7);
		produitS.save(produit8);
		produitS.save(produit9);
		produitS.save(produit10);
		produitS.save(produit11);
		produitS.save(produit12);
		produitS.save(produit13);
		produitS.save(produit14);
		produitS.save(produit15);
		produitS.save(produit16);
		produitS.save(produit17);
		produitS.save(produit18);
		produitS.save(produit19);
		produitS.save(produit20);
		produitS.save(produit21);
		produitS.save(produit22);
		produitS.save(produit23);
		produitS.save(produit24);
		produitS.save(produit25);
		produitS.save(produit26);
		produitS.save(produit27);
		produitS.save(produit28);
		produitS.save(produit29);
		produitS.save(produit30);
		produitS.save(produit31);
		produitS.save(produit32);
		produitS.save(produit33);
		produitS.save(produit34);
		produitS.save(produit35);
		produitS.save(produit36);
		produitS.save(produit37);
		produitS.save(produit38);
		produitS.save(produit39);
		produitS.save(produit40);
		produitS.save(produit41);
		produitS.save(produit42);
		produitS.save(produit43);
		produitS.save(produit44);
		produitS.save(produit45);
		produitS.save(produit46);
		produitS.save(produit47);
		produitS.save(produit48);
		produitS.save(produit49);
		produitS.save(produit50);
		produitS.save(produit51);
		produitS.save(produit52);
		
	}
	
	@Disabled
	@Transactional
	@Commit
	void createProf() {

		
		Maison m1 = new Maison("Griffondor");
		mService.save(m1);
		Prof p1 = new Prof("Pinel","Matthieu", "mattTestEleve",passwordEncoder.encode("matt"), LocalDate.parse("1998-02-23"),10000,m1);
		pRepo.save(p1);
		
		
	}
	@Disabled
	@Transactional
	@Commit
	void createAdmin() {

		Maison m1 = new Maison("Griffondor");
		
		mService.save(m1);
		
		Admin a1 = new Admin("Pinel","Matthieu", "mattTestAdmin",passwordEncoder.encode("matt"), LocalDate.parse("1998-02-23"),10000,m1);
		aService.create(a1);
		
	}

}
