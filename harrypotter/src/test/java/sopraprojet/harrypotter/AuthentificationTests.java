package sopraprojet.harrypotter;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.compte.Admin;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.repositories.ProfRepository;
import sopraprojet.harrypotter.service.AdminService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.MaisonService;
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
	


	@Test
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
				
		eService.save(e1);
		eService.save(e2);
		eService.save(e3);
		eService.save(e4);
	}
	
	@Test
	@Transactional
	@Commit
	void createProf() {

		Maison m1 = new Maison("Griffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Serdaigle");
		Maison m4 = new Maison("Poufsouffle");
		mService.save(m1);
		mService.save(m2);
		mService.save(m3);
		mService.save(m4);
		Prof p1 = new Prof("Pinel","Matthieu", "mattTestEleve",passwordEncoder.encode("matt"), LocalDate.parse("1998-02-23"),10000,m1);
		pRepo.save(p1);
		
		
	}
	@Test
	@Transactional
	@Commit
	void createAdmin() {

		Maison m1 = new Maison("Griffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Serdaigle");
		Maison m4 = new Maison("Poufsouffle");
		mService.save(m1);
		mService.save(m2);
		mService.save(m3);
		mService.save(m4);
		Admin a1 = new Admin("Pinel","Matthieu", "mattTestAdmin",passwordEncoder.encode("matt"), LocalDate.parse("1998-02-23"),10000,m1);
		aService.create(a1);
		
	}

}
