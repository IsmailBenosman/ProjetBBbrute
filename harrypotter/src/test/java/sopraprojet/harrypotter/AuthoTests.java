package sopraprojet.harrypotter;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Categorie;
import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.compte.Admin;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.entity.Role;
import sopraprojet.harrypotter.entity.Utilisateur;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.repositories.AdminRepository;
import sopraprojet.harrypotter.repositories.EleveRepository;
import sopraprojet.harrypotter.repositories.ProfRepository;
import sopraprojet.harrypotter.repositories.UtilisateurRepository;
import sopraprojet.harrypotter.service.PanierService;
@SpringBootTest
class AuthoTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UtilisateurRepository utilisateurRepo;
	
	@Autowired
	private EleveRepository eleveRepo;
	
	@Autowired
	private ProfRepository profRepo;
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	PanierService panierService;

	Maison maison = new Maison("Serpentard");
	Panier panier= new Panier();
	Panier panier1= new Panier();
	Boutique boutique = new Boutique(Categorie.Animaux, "Animalerie", "Sorry");
	
	Produit produit = new Produit(boutique, "Hibou", 50.65 ,"Elle s'appelle Hedwige");
	Produit produit1 = new Produit(boutique, "Rat", 10.25 ,"Il s'appelle Croutard");
	Produit produit2 = new Produit(boutique, "Crapaud", 0 ,"Il s'appelle Trevor");
	
	


	@Test
	@Transactional
	@Commit
	void createAdmin1() {
		Utilisateur u = new Utilisateur("admin", passwordEncoder.encode("admin"),
				new HashSet<Role>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_ELEVE, Role.ROLE_PROF)));
		utilisateurRepo.save(u);
	}
	

	@Test
	@Transactional
	@Commit
	void createProf1() {
		Utilisateur u = new Utilisateur("prof", passwordEncoder.encode("prof"),
				new HashSet<Role>(Arrays.asList(Role.ROLE_PROF)));
		utilisateurRepo.save(u);
	}

	@Test
	@Transactional
	@Commit
	void createEleve1() {
		Utilisateur u = new Utilisateur("eleve", passwordEncoder.encode("eleve"),
				new HashSet<Role>(Arrays.asList(Role.ROLE_ELEVE)));
		utilisateurRepo.save(u);
	}
	
	@Test
	@Transactional
	@Commit
	void createAdmin() {
		Admin u = new Admin(1,"Abid","Jordan","admin",passwordEncoder.encode("admin"), LocalDate.parse("1997-03-18"), 1000.0,"magie", maison, panier,
				new HashSet<Role>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_ELEVE, Role.ROLE_PROF)));
		adminRepo.save(u);
	}


	@Test
	@Transactional
	@Commit
	void createProf() {
		Prof u = new Prof(2,"Ye","Trex","trex",passwordEncoder.encode("trex"), LocalDate.parse("1997-03-18"), 1000.0,"magie",maison , panier,
				new HashSet<Role>(Arrays.asList(Role.ROLE_PROF)));
		profRepo.save(u);
	}

	@Test
	@Transactional
	@Commit
	void createEleve() {
		Eleve u = new Eleve(3,"rob","rob","rob",passwordEncoder.encode("rob"), LocalDate.parse("1997-03-18"), 1000.0,"magie", maison, panier,
				new HashSet<Role>(Arrays.asList(Role.ROLE_ELEVE)));
		eleveRepo.save(u);
	}



}
