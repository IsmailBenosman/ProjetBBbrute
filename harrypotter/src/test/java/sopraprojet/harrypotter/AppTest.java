package sopraprojet.harrypotter;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.InscriptionCours;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.InscriptionCoursService;



@SpringBootTest

class AppTest {

	@Autowired
	EleveService eleveService;
	@Autowired
	CoursService coursService;
	@Autowired
	InscriptionCoursService ICService;
	
	@Test
	@Transactional
	@Rollback
	void testInscription() {
		
		Eleve e = eleveService.getById(1);
		Cours c= coursService.getById(1);
		InscriptionCours i =new InscriptionCours(c, e);
		
		ICService.create(i);
		System.out.println(i);
		System.out.println(e.getCours());
	}
	
	
//	@Autowired
//	MaisonService maisonService;
//	@Disabled
//	@Test
//	
//	@Commit
//	void CreationEleveTest() {
//		
//		Maison maison = new Maison("Serpentard");
//		
//		Maison maison2 = new Maison("Poufsouffle");
//		Eleve e1 = new Eleve("Pierson", "Robin", "rob", "rob", LocalDate.parse("1997-03-18"), 0,maison);
//		Eleve e2 = new Eleve("Vong", "Michel", "michel", "michel", LocalDate.parse("1992-03-18"), 0,maison2);
//		maisonService.create(maison);
//		maisonService.create(maison2);
//		eleveService.create(e1);
//		eleveService.create(e2);
//	}
//	@Disabled
//	@Test
//	void eleveservicetest() {
//		assertNotNull(eleveService);
//	}
}
