package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import compte.Eleve;
import config.AppConfig;
import service.EleveService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class AppTest {

	@Autowired
	EleveService eleveService;
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void CreationEleveTest() {
		Eleve e1 = new Eleve("Pierson", "Robin", "rob", "rob", LocalDate.parse("1997-03-18"), 0,"Serpentard");
		Eleve e2 = new Eleve("Vong", "Michel", "michel", "michel", LocalDate.parse("1992-03-18"), 0,"Poufsouffle");
		eleveService.create(e1);
		eleveService.create(e2);
	}

	@Test
	void eleveservicetest() {
		assertNotNull(eleveService);
	}
}
