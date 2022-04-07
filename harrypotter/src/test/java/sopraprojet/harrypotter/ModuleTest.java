package sopraprojet.harrypotter;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.InscriptionCours;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.InscriptionCoursService;
import sopraprojet.harrypotter.service.MaisonService;
import sopraprojet.harrypotter.service.ModuleService;
import sopraprojet.harrypotter.service.ProfService;

@SpringBootTest
class ModuleTest {

	@Autowired
	ModuleService moduleService;
	@Autowired
	ProfService profService;
	@Autowired
	CoursService coursService;
	@Autowired
	EleveService eleveService;
	
	@Autowired
	MaisonService maisonService;
	@Autowired
	InscriptionCoursService inscriptioncoursService;
	@Disabled
	@Test
	@Transactional
	@Commit
	void ModuleTest() {
	
		Maison m1 = new Maison("Griffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Serdaigle");
		Maison m4 = new Maison("Poufsouffle");
		Eleve e1 = new Eleve("Pierson", "Robin", "testing", "rob", LocalDate.parse("1997-03-18"), 0,m2);
		Eleve e2 = new Eleve("Vong", "Michel", "michelTest", "michel", LocalDate.parse("1992-03-18"), 0,m4);
		Prof p1 = new Prof("Pinel","Matthieu", "mattTest","matt", LocalDate.parse("1998-02-23"),10000,m1);
		Cours co = new Cours("Histoire de la magie", p1);
		Cours co1 = new Cours("Métamorphose", p1);
		Cours co2 = new Cours("Défense", p1);
		Modules m = new Modules(co, 14, "Sur la bonne voie",e1);
		Modules m11 = new Modules(co1, 11, "Passable",e1);
		Modules m22 = new Modules(co2, 5, "Aie",e1);
		Modules m33 = new Modules(co, 18, "Excellent",e2);
		Modules m44 = new Modules(co1, 13, "Pas mal",e2);
		Modules m55 = new Modules(co2, 2, "Tu viendras me voir",e2);
		InscriptionCours i1 = new InscriptionCours(co, e1);
		InscriptionCours i2 = new InscriptionCours(co, e2);
		maisonService.create(m1);
		maisonService.create(m2);
		maisonService.create(m3);
		maisonService.create(m4);
		eleveService.create(e1);
		eleveService.create(e2);
		profService.create(p1);
		coursService.create(co);
		coursService.create(co1);
		coursService.create(co2);
		inscriptioncoursService.create(i1);
		inscriptioncoursService.create(i2);
		System.out.println("_____________________________________________________");
		System.out.println(inscriptioncoursService.findByCours(co));
		System.out.println("_____________________________________________________");
		moduleService.create(m);
		moduleService.create(m11);
		moduleService.create(m22);
		moduleService.create(m33);
		moduleService.create(m44);
		moduleService.create(m55);
		System.out.println(moduleService.moyenne(e2));
	}

}
