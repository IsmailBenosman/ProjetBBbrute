package sopraprojet.harrypotter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Livraison;
import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.compte.Admin;
import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Cours;


import sopraprojet.harrypotter.ecole.Evenement;

import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.repositories.BoutiqueRepository;
import sopraprojet.harrypotter.repositories.CoursRepository;
import sopraprojet.harrypotter.repositories.EvenementRepository;
import sopraprojet.harrypotter.repositories.LivraisonRepository;
import sopraprojet.harrypotter.repositories.ModuleRepository;
import sopraprojet.harrypotter.repositories.ProfRepository;
import sopraprojet.harrypotter.service.AdminService;
import sopraprojet.harrypotter.service.BoutiqueService;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.MaisonService;
import sopraprojet.harrypotter.service.ModuleService;
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
	private ModuleRepository moduleR;
	@Autowired
	private CoursRepository coursR;
	@Autowired
	EvenementRepository eventR;
	@Autowired
	LivraisonRepository livraisonR;



	@Disabled
	@Transactional
	@Commit
	void createEleve() {
		
		Maison m1 = new Maison("Griffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Serdaigle");
		Maison m4 = new Maison("Poufsouffle");
		mService.create(m1);
		mService.create(m2);
		mService.create(m3);
		mService.create(m4);
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
		Eleve e5 = new Eleve("Anais", "Clavel-L'Haridon", "Anais", passwordEncoder.encode("Anais"), null, 0, m4);
		eService.create(e5);
		Eleve e6 = new Eleve("Hugo", "Michel", "Hugo", passwordEncoder.encode("Hugo"), null, 0, m3);
		eService.create(e6);
		Prof p1 = new Prof("Pinel","Matthieu", "Matthieu",passwordEncoder.encode("Matthieu"), LocalDate.parse("1998-02-23"),10000,m1);
		pRepo.save(p1);
		Prof p2 = new Prof("Benosman","Ismail", "Ismail",passwordEncoder.encode("Ismail"), LocalDate.parse("1996-02-16"),10000,m4);
		pRepo.save(p2);
		Prof p3 = new Prof("Ye","Elisabeth", "Elisabeth",passwordEncoder.encode("Elisabeth"), LocalDate.parse("1996-10-15"),10000,m3);
		pRepo.save(p3);	
		Prof p4 = new Prof("Gozlan","Olivier", "Olivier",passwordEncoder.encode("Olivier"), LocalDate.parse("1996-10-15"),10000,m2);
		pRepo.save(p4);
		
		//Panier panier = new Panier(int quantite, Compte compte, boolean achat, Produit articles, LocalDateTime dateAchat)
		Admin a1 = new Admin("Abid","Jordan", "Jordan",passwordEncoder.encode("Jordan"), LocalDate.parse("1998-02-23"),10000,m2);
		aService.create(a1);

		Cours co = new Cours("Histoire de la magie", p1);
		Cours co1 = new Cours("Métamorphose", p1);
		Cours co2 = new Cours("Défense", p1);
		Cours co3 = new Cours("Initiation au balai", p2);
		Cours co4 = new Cours("Potions", p2);
		Cours co5 = new Cours("Soins aux creatures magiques", p2);
		Cours co6 = new Cours("Divination", p3);
		Cours co7 = new Cours("Astronomie", p3);
		Cours co8 = new Cours("Arithmancie", p3);
		Modules m = new Modules(co, 14, "Sur la bonne voie",e1);
		Modules m11 = new Modules(co1, 11, "Passable",e1);
		Modules m12 = new Modules(co2, 5, "Aie",e1);
		Modules m21 = new Modules(co, 18, "Excellent",e2);
		Modules m22 = new Modules(co1, 13, "Pas mal",e2);
		Modules m23 = new Modules(co2, 2, "Tu viendras me voir",e2);
		Modules m31 = new Modules(co3,7,"Il faut reprendre ça",e3);
		Modules m32 = new Modules(co4,16,"Tres bien",e3);
		Modules m33 = new Modules(co5,19,"Tu es faites pour t'occuper des animaux",e3);
		Modules m41 = new Modules(co6,17,"Ton esprit s'est revele",e5);
		Modules m42 = new Modules(co7,9,"Reprends un peu le cours et ça va le faire",e5);
		Modules m43 = new Modules(co8,16,"Excellent travail",e5);
		Modules m51 = new Modules(co6,6,"Ton esprit est trop terre a terre",e6);
		Modules m52 = new Modules(co7,19,"L'espace n'a plus de secret pour toi",e6);
		Modules m53 = new Modules(co8,16,"On voit que tu aimes les maths",e6);
		/*InscriptionCours i1 = new InscriptionCours(co, e1);
		InscriptionCours i2 = new InscriptionCours(co, e2);
		InscriptionCours i3 = new InscriptionCours(co3, e3);
		InscriptionCours i4 = new InscriptionCours(co3, e4);
		InscriptionCours i5 = new InscriptionCours(co2, e1);
		InscriptionCours i6 = new InscriptionCours(co2, e4);
		InscriptionCours i7 = new InscriptionCours(co5, e2);
		InscriptionCours i8 = new InscriptionCours(co5, e3);
		InscriptionCours i9 = new InscriptionCours(co6, e5);
		InscriptionCours i10 = new InscriptionCours(co7, e5);
		InscriptionCours i11 = new InscriptionCours(co8, e5);
		InscriptionCours i12 = new InscriptionCours(co6, e6);
		InscriptionCours i13 = new InscriptionCours(co7, e6);
		InscriptionCours i14 = new InscriptionCours(co8, e6);*/

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
		//boutiqueS.create(b16);
		
		Produit produit1= new Produit(b1,"Balétoile XXI", 200.0, "Le Balétoile XXI est un balai de course. Il est utilisé par l'équipe de Quidditch des États-Unis lors de la Coupe du Monde de Quidditch de 2014.");
		Produit produit2= new Produit(b1,"La Bombe bleue", 200.0, "La Bombe bleue  est un balai familial sûr, stable et équipé d'une sirène antivol");
		Produit produit3= new Produit(b1,"Le Brossdur 1", 200.0, "Le Brossdur 1 est un modèle de balais de course, produit en 1926 par la Compagnie des balais Brossdur.");
		/*Produit produit4= new Produit(b1,"Le Brossdur 2", 200.0, "Le Brossdur 2 est un modèle de balais de course, produit en 1934 par la Compagnie des balais Brossdur.");
		Produit produit5= new Produit(b1,"Le Brossdur 3", 200.0, "Le Brossdur 3 est un modèle de balais de course, produit en 1937 par la Compagnie des balais Brossdur.");
		Produit produit6= new Produit(b1,"Le Brossdur 5", 200.0, "Le Brossdur 5 , aussi appelé Astiqueur 5, est un modèle de balais de course, produit par la Compagnie des balais Brossdur. Les jumeaux Weasley en étaient propriétaires");
		Produit produit7= new Produit(b1,"Le Brossdur 6", 200.0, "Le Brossdur 6 est un modèle de balais de course, produit par la Compagnie des Balais Brossdur.");
		Produit produit8= new Produit(b1,"Le Brossdur 7", 200.0, "Le Brossdur 7 est un modèle de balais de course, produit par la Compagnie des Balais Brossdur.");
		Produit produit9= new Produit(b1,"Le Brossdur 11", 200.0, "Le Brossdur 11 (  Angl.  Cleansweep Eleven ) est un modèle de balais de course, produit par la Compagnie des balais Brossdur, capable de passer de 0 à 100 km/h en dix secondes.");
		*/Produit produit10= new Produit(b1,"Le Comète 140", 200.0, "Le Comète 140 est un modèle de balais de course, produit par la Compagnie de la comète. Il doit le chiffre de son nom aux cent quarante exemplaires testés avant d'en lancer sa commercialisation.");
		/*Produit produit11= new Produit(b1,"Le Comète 180", 200.0, "Le Comète 180 est un modèle de balais de course, produit en 1938 par la Compagnie de la comète. Il est le rival du Brossdur 2 et du Brossdur 3.");
		Produit produit12= new Produit(b1,"Le Comète 260", 200.0, "Le Comète 260 est un modèle de balais de course, produit par la Compagnie de la comète.");
		Produit produit13= new Produit(b1,"Le Comète 290", 200.0, "Le Comète 290 est un modèle de balais de course, produit par la Compagnie de la comète.");
		*/Produit produit14= new Produit(b1,"L'Éclair de Feu", 200.0, "L'Éclair de Feu est un balai volant sorti en 1993. C'est le balai le plus rapide au monde.");
		//Produit produit15= new Produit(b1,"L'Éclair de Feu Suprême", 200.0, "L'Éclair de Feu Suprême est un balai de course. Il est utilisé par l'équipe de Quidditch de Bulgarie lors de la Coupe du Monde de Quidditch de 2014.[1]");
		Produit produit16= new Produit(b1,"L'Étoile filante", 200.0, "l'Étoile filante est produite en 1955 par la Compagnie des balais universels. Il s'agit alors du balai de course le moins cher du marché.");
		/*Produit produit17= new Produit(b1,"Le Flèche d'Argent", 200.0, "Le Flèche d'Argent est un précurseur du balai de course et atteint des vitesses très supérieures au Lancechêne 79 et au Friselune.");
		Produit produit18= new Produit(b1,"Le Feuopoudre", 200.0, "Le Feuopoudre  est un modèle de balai de course, produit à partir de 1940 par la Compagnie Ellerby et Spudmore. Bien qu'étant un modèle très résistant, sa vitesse l'empêche de rivaliser avec les deux grandes marques de l'époque : Brossdur et Comète.");
		Produit produit19= new Produit(b1,"Le Friselune", 200.0, "Le Friselune a représenté un bond en avant dans la construction des balais et, pendant longtemps, il fut très demandé par les joueurs de Quidditch. Son principal avantage était sa capacité à atteindre des altitudes importantes tout en restant contrôlable. ");
		Produit produit20= new Produit(b1,"Le Lancechêne 79", 200.0, "Le Lancechêne 79 est nommé ainsi en référence à l'année de sa création, 1879. Il s'agit d'un balai conçu pour les vols d'endurance et la résistance aux vents violents. C'est maintenant un balai de collection très recherché");
		Produit produit21= new Produit(b1,"Le MancheviF", 200.0, "Le Manchevif est un modèle de balai de course, produit en 1952 par la Compagnie Ellerby et Spudmore. Bien qu'étant plus rapide que son prédécesseur, le Feuopoudre, il perd de la puissance en montée.");
		Produit produit22= new Produit(b1,"Le Margotin 90", 200.0, "Le Margotin 90 est un modèle de balais de course, produit pour la première fois en 1990 par la compagnie Flyte et Barker. Ce balai de course est doté de gadgets, tels qu'un correcteur de trajectoire ou bien encore d'un sifflet d'alarme.");
		Produit produit23= new Produit(b1,"Le Nimbus 1001", 200.0, "Le Nimbus 1001 est un modèle de balais de course, produit par la Société des balais de course Nimbus. Successeur du Nimbus 1000, il a permis à la société de demeurer au premier rang.");
		Produit produit24= new Produit(b1,"Le Nimbus 1500", 200.0, "Le Nimbus 1500 est un modèle de balais de course, produit par la Société des balais de course Nimbus. Il a permis à la société de demeurer au premier rang.");
		Produit produit25= new Produit(b1,"Le Nimbus 1700", 200.0, "Le Nimbus 1700 est un modèle de balais de course, produit par la Société des balais de course Nimbus. Il a permis à la société de demeurer au premier rang.");
		*/Produit produit26= new Produit(b1,"Le Nimbus 2000", 200.0, "Le Nimbus 2000 est un balai de course, le plus rapide des balais à sa sortie en 1991. L'année suivante, le Nimbus 2001 fut commercialisé et détrôna son frère.");
		Produit produit27= new Produit(b1,"Le Nimbus 2001", 200.0, "Le Nimbus 2001 est le successeur du Nimbus 2000 en tant que balai de course. Il est le plus rapide des balais jusqu'à la sortie de l'Éclair de Feu l'année suivante, en 1993.");
		/*Produit produit28= new Produit(b1,"Le Varápidos", 200.0, "Le Varápidos est un balai de course. Il est utilisé par l'équipe de Quidditch du Brésil lors de la Coupe du Monde de Quidditch de 2014.");
		Produit produit29= new Produit(b1,"Le Yajirushi", 200.0, "Le Yajirushi est un balai de course. Il est utilisé par l'équipe de Quidditch du Japon lors de la Coupe du Monde de Quidditch de 2014. Il a été révélé pour la première fois au cours de ce tournoi.");
		*/Produit produit30= new Produit(b6,"Le Boursouf" ,200, "Le Boursouf est un charognard qui mange n'importe quoi avec sa longue langue extensible et notamment les restes de repas ou les araignées, mais il apprécie plus particulièrement les crottes de nez des sorciers,");
		//Produit produit31= new Produit(b6,"Le Boursouflet" ,200, "On dit du Boursouflet, qu'il est adorable, mignon et qu'il donne envie de le caresser. Les Boursouflets peuvent rouler sur eux-mêmes, émettre des cris aigus...");
		Produit produit32= new Produit(b6,"Le Chat Blanc" ,9, "Le chat blanc a souvent des beaux yeux bleus qui créent un contraste saisissant avec sa robe d'un blanc neige.");
		/*Produit produit33= new Produit(b6,"Le Chat Tigré" ,9, "Le chat tigré est facilement reconnaissable grâce à sa robe rayée de couleur grise, marron ou rousse. Il est aussi appelé chat de gouttière.");
		Produit produit34= new Produit(b6,"Le Chat Noir" ,9, "Le chat noir est un animal de compagnie fidèle et agréable.");
		Produit produit35= new Produit(b6,"Le Chat Roux" ,9, "Le chat roux est un magnifique chat roux taché de noir. Il est en vente à la Ménagerie magique pour neuf Gallions");
		Produit produit36= new Produit(b6,"Le Chat Siamois" ,11, "Avec ses magnifiques yeux perçants, sa silhouette fine et sa tête triangulaire, le chat siamois est considéré par certains comme la plus belle race de félins.");
		Produit produit37= new Produit(b6,"La Chauve-Souris" ,5, "La chauve-souris est un animal non magique. Elle peut servir de décoration seule ou en groupe et son foie entre dans la composition de certaines potions");
		Produit produit38= new Produit(b6,"Crapaud violet géant" ,5, "Le crapaud violet géant est un animal friand de mouches mortes et autres insectes.");
		Produit produit39= new Produit(b6,"Le Crabe de Feu" ,5, "Le Crabe de Feu  malgré son nom ne ressemble non pas à un crabe mais à une tortue dont la carapace est incrustée de pierres précieuses.");
		Produit produit40= new Produit(b6,"Le Fléreur" ,5, "Le Fléreur, également appelé Kneazle, est une petite créature poilue, proche du chat, connue pour son intelligence et sa clairvoyance. Originaire de Grande-Bretagne, l'animal est aujourd'hui présent dans le monde entier.");
		*/Produit produit41= new Produit(b11,"La chouette des bois" ,10, "La chouette des bois possède une vision binoculaire ainsi qu'une audition directionnelle exceptionnelle. Ces atouts font d'elle un redoutable prédateur nocturne. Elle se nourrit essentiellement de petits rongeurs et de mulots.");
		/*Produit produit42= new Produit(b11,"La chouette effraie" ,10, "La chouette effraie est très répandue en Europe. C'est un oiseau qui possède une ouïe très développée.");
		Produit produit43= new Produit(b11,"La chouette hulotte" ,10, "La chouette hulotte a une ouïe très développée. Le mâle et la femelle communiquent en hululant longuement.");
		Produit produit44= new Produit(b11,"houette lapone" ,10, "Errol (qui appartient à la famille Weasley ) est une chouette lapone.");
		Produit produit45= new Produit(b11,"Le Grand-duc" ,10, "Le Grand-duc fait parti des animaux de compagnie dans le monde des sorciers.");
		Produit produit46= new Produit(b11,"Le petit-duc" ,15, "Le petit-duc est un oiseau extrêmement agile qui se nourrit de lapins, de mulots, de rats, de souris et de reptiles.");
		*/Produit produit47= new Produit(b6,"Lapin" ,10, "Les lapins sont des animaux de compagnie dans le monde des sorciers aussi bien que dans le monde des Moldus.");
		Produit produit48= new Produit(b6,"Le Musard" ,10, "Le Musard est un escargot géant qui change de couleur toutes les heures.");
		//Produit produit49= new Produit(b6,"Le Niffleur" ,10, "Le Niffleur est une petite créature à la fourrure noire qui a une prédilection pour tout ce qui brille.");
		Produit produit50= new Produit(b6,"Le rat noir" ,10, "Le rat noir est apparemment plus intelligent que les autres rats.");
		/*Produit produit51= new Produit(b6,"Le rat gris" ,10, "C'est la variété de rat à laquelle Croûtard appartient.");
		Produit produit52= new Produit(b6,"Le triton à double queue" ,10, "Le triton à double queue est un animal de compagnie des sorciers.");
		*/Produit produit53= new Produit(b7,"Baguette de Chadwick Boot" ,10, "Frêne épineux, corne de serpent cordnu");
		Produit produit54= new Produit(b7,"Baguette de Jacob " ,10,
				  "Bois d'érable, ventricule de dragon");
		Produit produit55= new Produit(b7,"Baguette de Marwood" ,10,
				  "Bois de pommier, crin de licorne");
		Produit produit56= new Produit(b7,"Baguette de Cattermole" ,10,
				  "Bois de cerisier, cheveu de Vélane"); 
		Produit produit57= new Produit(b7,"Baguette de Catogan" ,10,
				  "Bois de prunellier, moustache de troll");
				  /*Produit produit58= new Produit(b7,"Baguette de " ,10,
				  "Le triton à double queue est un animal de compagnie des sorciers."); Produit
				  produit59= new Produit(b7,"Baguette de " ,10,
				  "Le triton à double queue est un animal de compagnie des sorciers."); Produit
				  produit60= new Produit(b7,"Baguette de " ,10,
				  "Le triton à double queue est un animal de compagnie des sorciers."); Produit
				  produit61= new Produit(b7,"Baguette de " ,10,
				  "Le triton à double queue est un animal de compagnie des sorciers."); Produit
				  produit62= new Produit(b7,"Baguette de " ,10,
				  "Le triton à double queue est un animal de compagnie des sorciers.");
		*/Produit produit89 = new Produit(b2, "Menthe poivrée", 3.60 ,"Une plante très utilisée pour les confiseries");
		Produit produit90 = new Produit(b2, "Valériane", 6.50 ,"Un bon remède naturel");
		Produit produit91 = new Produit(b2, "Têtes de coquelicot", 7.25 ,"Utile pour des potions du sommeil ou d'amnésie");
		Produit produit92 = new Produit(b2, "Belladone", 20.50 ,"Manger 6 baies de cette plante est mortel");
		Produit produit93 = new Produit(b2, "Aconit", 5.50 ,"Plante très toxique");
		Produit produit94 = new Produit(b2, "La Digitale", 6.50 ,"Plante vénéneuse au toucher");
		Produit produit95 = new Produit(b2, "Branchiflore", 11 ,"Une plante qui permet de respirer sous l'eau");
		
		
		  
		 
		Produit produit96 = new Produit(b3, "Bieraubeurre", 3.50 ,"Un grand classique de la maison");
		Produit produit97 = new Produit(b3, "Jus de citrouille", 2.50 ,"Un jus très prisé des sorciers");
		Produit produit98 = new Produit(b3, "Jus d'oeuillet", 3.25 ,"Un jus vitaminé qui pétille");
		Produit produit99 = new Produit(b3, "Whisky pur feu", 5.50 ,"Un brevage très alcoolisé");
		Produit produit100 = new Produit(b3, "Cognac", 7 ,"Un tord-boyau qui purifie");
		Produit produit101 = new Produit(b4, "Chroniques de Lockhart vol1", 15 ,"Un best-seller sur le grand Guildoroy Lockhart");
		Produit produit102 = new Produit(b4, "Chroniques de Lockhart vol2", 15 ,"La suite du best-seller");
		Produit produit103 = new Produit(b4, "Chroniques de Lockhart vol3", 15 ,"Epilogue du best-seller");
		Produit produit104 = new Produit(b4, "Monstrueux livre des monstres", 11.50 ,"Tout savoir sur les créatures magiques");
		Produit produit105 = new Produit(b4, "Histoire de sang-mele", 12 ,"Témoignages d'un sang-mele");
		Produit produit106 = new Produit(b5, "Compte sorcier", 3 ,"Un compte bancaire pour tout sorcier");
		Produit produit107 = new Produit(b5, "Compte sage", 2 ,"Un compte bancaire pour plus de 60 ans");
		Produit produit108 = new Produit(b5, "Compte premium", 7 ,"Un compte bancaire pour les revenus aises");
		Produit produit109 = new Produit(b5, "Compte aurore", 2 ,"Un compte bancaire pour les aurores");
		
		Produit produit110 = new Produit(b8, "Oreilles a rallonge", 9 ,"Pour écouter à distance");
		Produit produit111 = new Produit(b8, "Marécage portable", 6 ,"Un petit coin de nature à portee de main");
		Produit produit112 = new Produit(b8, "Pendu réutilisable", 3 ,"Trouvez le bon sort ou il aura la corde au cou");
		Produit produit113 = new Produit(b8, "Baguette farceuse", 7.50 ,"Baguette qui se transforme quand est utilise");
		Produit produit114 = new Produit(b8, "Cartes pipees", 2 ,"Pour faire des tours incroyables");
		Produit produit115 = new Produit(b9, "Cranes humains", 10 ,"Plus glauque tu meurs");
		Produit produit116 = new Produit(b9, "Main de la gloire", 6 ,"Reserve au bonne poigne");
		Produit produit117 = new Produit(b9, "Gros oeil de verre", 4 ,"Envie d'un troiseme oeil ?");
		Produit produit118 = new Produit(b9, "Jeu de cartes ensanglentes", 2.50 ,"Pour les soires gore");
		Produit produit119 = new Produit(b10, "Potion de sommeil", 5 ,"Permet de dormir sur ses deux oreilles");
		Produit produit120 = new Produit(b10, "Potion de metamorphose", 6 ,"Transformez vous en ce que vous voulez");
		Produit produit121 = new Produit(b10, "Potion d'amnesie", 9 ,"Perte de la memoire pendant 2 heures");
		Produit produit122 = new Produit(b10, "Filtre d'amour", 15 ,"Votre moitie est dingue de vous pendant 1 journee");
		Produit produit123 = new Produit(b10, "Potion du silence", 3.50 ,"Aucun son ne sortira de votre bouche durant 3h");
		Produit produit124 = new Produit(b11, "Rat des champs", 4 ,"Un rat sauvage tres farouche");
		Produit produit125 = new Produit(b11, "Rat des villes", 4.50 ,"Un rat tres casanier");
		Produit produit126 = new Produit(b11, "Grenouille", 5 ,"Un animal docile et attachant");
		Produit produit127 = new Produit(b11, "Crapaud", 5.50 ,"Un animal repoussant au regard mais affectueux");
		/*Produit produit128 = new Produit(b11, "Chat", 8 ,"Le plus mignon des animaux");
		Produit produit129 = new Produit(b11, "Hibou", 10 ,"Un animal messager tres fidele");
		*/Produit produit130 = new Produit(b12, "Robe de sorcier", 15 ,"Une tenue tres prisee des sorciers");
		Produit produit131 = new Produit(b12, "Chapeau", 6 ,"Couvre-chef avec un look magique");
		Produit produit132 = new Produit(b12, "Blazer de poudlard", 18 ,"Costume saillant et chic");
		//Produit produit133 = new Produit(b12, "Pantalon", 12 ,"Un pantalon sobre et chic");
		Produit produit134 = new Produit(b13, "Echarpe de Griffondor", 7 ,"Une echarpe a l'effigie des rouges");
		Produit produit135 = new Produit(b13, "Echarpe de Serpentard", 7 ,"Une echarpe a l'effigie des verts");
		Produit produit136 = new Produit(b13, "Echarpe de Serdaigle", 7 ,"Une echarpe a l'effigie des bleus");
		Produit produit137 = new Produit(b13, "Echarpe de Poufsouffle", 7 ,"Une echarpe a l'effigie des jaunes");
		Produit produit138 = new Produit(b14, "Poncho", 10 ,"Un look hispanique");
		Produit produit139 = new Produit(b14, "Salopette", 14 ,"Gutten tag");
		Produit produit140 = new Produit(b14, "Mariniere", 8 ,"Un look so frenchie");
		Produit produit141 = new Produit(b15, "Jupe", 13 ,"Une jupe elegante et raffinee");
		Produit produit142 = new Produit(b15, "Ceinture", 4 ,"Pour rester classe en toute circonstance");
		Produit produit143 = new Produit(b15, "Chaussettes", 6.50 ,"Une paire de chaussettes tout ce qu'il y a de plus banal");
		
		Evenement event1 = new Evenement("Bal de fin d'annee",LocalDate.parse("2023-07-28"), LocalTime.of(23, 0,0));
		Evenement event2 = new Evenement("Tournoi des 4 Maisons",LocalDate.parse("2022-09-03"), LocalTime.of(14,30,0));
		Evenement event3 = new Evenement("Finale de Quidditch ",LocalDate.parse("2022-06-01"), LocalTime.of(21, 0,0));
		Evenement event4 = new Evenement("Banquet de Noel",LocalDate.parse("2022-12-20"), LocalTime.of(20,30,0));
		List<Eleve> participant2 = new ArrayList();
		List<Eleve> participant3 = new ArrayList();
		Collections.addAll(participant2, e1,e2,e3,e4);
		Collections.addAll(participant3, e1,e2,e3,e4,e5,e6);
		event1.setParticipants(participant3);
		event2.setParticipants(participant2);
		event3.setParticipants(participant3);
		List<Livraison> modes = new ArrayList();
		Livraison livraison = new Livraison("LaPoste", 0.50, "Livraison sous 14 jours");
		Livraison livraison1 = new Livraison("Hiboux", 5.20, "Livraison sous 7 jours");
		Livraison livraison2= new Livraison("Dragon", 7.80, "Livraison sous 3 jours");
		Livraison livraison3 = new Livraison("Elfe", 10.99, "Livraison dans l'heure");
		Collections.addAll(modes, livraison,livraison1,livraison2,livraison3);
		b1.setModeLivraison(modes);
		b4.setModeLivraison(modes);
		b8.setModeLivraison(modes);
		b9.setModeLivraison(modes);
		b16.setModeLivraison(modes);
		livraisonR.save(livraison);
		livraisonR.save(livraison1);
		livraisonR.save(livraison2);
		livraisonR.save(livraison3);
		eventR.save(event1);
		eventR.save(event2);
		eventR.save(event3);
		eventR.save(event4);
		produitS.save(produit1);
		produitS.save(produit2);
		produitS.save(produit3);
		/*produitS.save(produit4);
		produitS.save(produit4);
		produitS.save(produit5);
		produitS.save(produit6);
		produitS.save(produit7);
		produitS.save(produit8);
		produitS.save(produit9);*/
		produitS.save(produit10);
		/*produitS.save(produit11);
		produitS.save(produit12);
		produitS.save(produit13);*/
		produitS.save(produit14);
		//produitS.save(produit15);
		produitS.save(produit16);
		/*produitS.save(produit17);
		produitS.save(produit18);
		produitS.save(produit19);
		produitS.save(produit20);
		produitS.save(produit21);
		produitS.save(produit22);
		produitS.save(produit23);
		produitS.save(produit24);
		produitS.save(produit25);*/
		produitS.save(produit26);
		produitS.save(produit27);
		/*produitS.save(produit28);
		produitS.save(produit29);*/
		produitS.save(produit30);
		//produitS.save(produit31);
		produitS.save(produit32);
		/*produitS.save(produit33);
		produitS.save(produit34);
		produitS.save(produit35);
		produitS.save(produit36);
		produitS.save(produit37);
		produitS.save(produit38);
		produitS.save(produit39);
		produitS.save(produit40);*/
		produitS.save(produit41);
		/*produitS.save(produit42);
		produitS.save(produit43);
		produitS.save(produit44);
		produitS.save(produit45);
		produitS.save(produit46);*/
		produitS.save(produit47);
		produitS.save(produit48);
		//produitS.save(produit49);
		produitS.save(produit50);
		/*produitS.save(produit51);
		produitS.save(produit52);*/
		produitS.save(produit53);
		produitS.save(produit54);
		produitS.save(produit55);
		produitS.save(produit56);
		produitS.save(produit57);
		/*produitS.save(produit58);
		produitS.save(produit59);
		produitS.save(produit60);
		produitS.save(produit61);
		produitS.save(produit62);*/
		produitS.save(produit89);
		produitS.save(produit90);
		produitS.save(produit91);
		produitS.save(produit92);
		produitS.save(produit93);
		produitS.save(produit94);
		produitS.save(produit95);
		produitS.save(produit96);
		produitS.save(produit97);
		produitS.save(produit98);
		produitS.save(produit99);
		produitS.save(produit100);
		produitS.save(produit101);
		produitS.save(produit102);
		produitS.save(produit103);
		produitS.save(produit104);
		produitS.save(produit105);
		produitS.save(produit106);
		produitS.save(produit107);
		produitS.save(produit108);
		produitS.save(produit109);
		produitS.save(produit110);
		produitS.save(produit111);
		produitS.save(produit112);
		produitS.save(produit113);
		produitS.save(produit114);
		produitS.save(produit115);
		produitS.save(produit116);
		produitS.save(produit117);
		produitS.save(produit118);
		produitS.save(produit119);
		produitS.save(produit120);
		produitS.save(produit121);
		produitS.save(produit122);
		produitS.save(produit123);
		produitS.save(produit124);
		produitS.save(produit125);
		produitS.save(produit126);
		produitS.save(produit127);
		/*produitS.save(produit128);
		produitS.save(produit129);*/
		produitS.save(produit130);
		produitS.save(produit131);
		produitS.save(produit132);
		/*produitS.save(produit133);
		produitS.save(produit134);
		produitS.save(produit135);
		produitS.save(produit136);
		produitS.save(produit137);*/
		produitS.save(produit138);
		produitS.save(produit139);
		produitS.save(produit140);
		produitS.save(produit141);
		produitS.save(produit142);
		produitS.save(produit143);
		coursR.save(co);
		coursR.save(co1);
		coursR.save(co2);
		coursR.save(co3);
		coursR.save(co4);
		coursR.save(co5);
		coursR.save(co6);
		coursR.save(co7);
		coursR.save(co8);
		moduleR.save(m);
		moduleR.save(m11);
		moduleR.save(m12);
		moduleR.save(m21);
		moduleR.save(m22);
		moduleR.save(m23);
		moduleR.save(m31);
		moduleR.save(m32);
		moduleR.save(m33);
		moduleR.save(m41);
		moduleR.save(m42);
		moduleR.save(m43);
		moduleR.save(m51);
		moduleR.save(m52);
		moduleR.save(m53);
		List<Cours> cours_eleve = new ArrayList();
		Collections.addAll(cours_eleve,co,co1,co2);
		e1.setCours(cours_eleve);
		/*inscriptionR.save(i1);
		inscriptionR.save(i2);
		inscriptionR.save(i3);
		inscriptionR.save(i4);
		inscriptionR.save(i5);
		inscriptionR.save(i6);
		inscriptionR.save(i7);
		inscriptionR.save(i8);
		inscriptionR.save(i9);
		inscriptionR.save(i10);
		inscriptionR.save(i11);
		inscriptionR.save(i12);
		inscriptionR.save(i13);
		inscriptionR.save(i14);*/
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
