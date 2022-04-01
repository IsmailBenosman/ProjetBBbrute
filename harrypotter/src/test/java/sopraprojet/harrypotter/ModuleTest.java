package sopraprojet.harrypotter;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.module.Cours;
import sopraprojet.harrypotter.module.Modules;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
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
	
	@Test
	@Transactional
	@Commit
	void ModuleTest() {
		
		
		Maison maison = new Maison("Griffondor");
		Eleve e1 = new Eleve("Pierson", "Robin", "rob", "rob", LocalDate.parse("1997-03-18"), 0,maisonService.getById(2));
		Prof p1 = new Prof("Pinel","Matthieu", "matt","matt", LocalDate.parse("1998-02-23"),10000,maison);
		Cours co = new Cours("Histoire de la magie", p1);
		Modules m = new Modules(co, 14, "Sur la bonne voie",e1);
		maisonService.create(maison);
		eleveService.create(e1);
		profService.create(p1);
		coursService.create(co);
		moduleService.create(m);
	}

}
