package sopraprojet.harrypotter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.service.EleveService;



@SpringBootTest
class AppTest {

	@Autowired
	EleveService eleveService;
	
	
	@Test
	@Transactional
	@Commit
	void CreationEleveTest() {
//		Eleve e1 = new Eleve("Pierson", "Robin", "rob", "rob", LocalDate.parse("1997-03-18"), 0,"Serpentard");
//		Eleve e2 = new Eleve("Vong", "Michel", "michel", "michel", LocalDate.parse("1992-03-18"), 0,"Poufsouffle");
//		eleveService.create(e1);
//		eleveService.create(e2);
	}

	@Test
	void eleveservicetest() {
		assertNotNull(eleveService);
	}
}
