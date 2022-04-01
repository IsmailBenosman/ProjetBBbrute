package sopraprojet.harrypotter;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.module.Cours;
import sopraprojet.harrypotter.module.InscriptionCours;
import sopraprojet.harrypotter.module.Modules;
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
	InscriptionCoursService inscriptioncoursService;
	@Autowired
	MaisonService maisonService;
	@Test
	@Transactional
	@Commit
	void ModuleTest() {
		Maison m1 = new Maison("Griffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Serdaigle");
		Maison m4 = new Maison("Poufsouffle");
		Eleve e1 = new Eleve("Pierson", "Robin", "rob", "rob", LocalDate.parse("1997-03-18"), 0,m2);
		Eleve e2 = new Eleve("Vong", "Michel", "michel", "michel", LocalDate.parse("1992-03-18"), 0,m4);
		Prof p1 = new Prof("Pinel","Matthieu", "matt","matt", LocalDate.parse("1998-02-23"),10000,m1);
		Cours co = new Cours("Histoire de la magie", p1);
		Modules m = new Modules(co, 14, "Sur la bonne voie",e1);
		InscriptionCours i1 = new InscriptionCours(co, e1);
		InscriptionCours i2 = new InscriptionCours(co, e2);
		/*List <InscriptionCours> inscris = new ArrayList();
		Collections.addAll(inscris,i1,i2);
		((Eleve) inscris).getEleve();*/
		maisonService.create(m1);
		maisonService.create(m2);
		maisonService.create(m3);
		maisonService.create(m4);
		eleveService.create(e1);
		eleveService.create(e2);
		profService.create(p1);
		coursService.create(co);
		inscriptioncoursService.create(i1);
		inscriptioncoursService.create(i2);
		System.out.println(inscriptioncoursService.findEleveByCours(co));
		moduleService.create(m);
	}

}
