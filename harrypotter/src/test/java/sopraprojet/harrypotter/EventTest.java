package sopraprojet.harrypotter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.EvenementService;
import sopraprojet.harrypotter.service.MaisonService;



@SpringBootTest
class EventTest {
	

	@Autowired
	EvenementService evenementService;
	
	@Autowired
	EleveService eleveService;
	
	@Autowired
	MaisonService maisonService;
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void CreationEventTest() {
		Evenement event = new Evenement("Tournoi des quatre Maisons",LocalDate.parse("2023-07-12"), LocalTime.of(11, 0,0));
		evenementService.create(event);
	}
	
	@Disabled
	@Test
	@Transactional
	@Commit
//	@Rollback
	void CreationEventEleveTest() {
		Evenement event = new Evenement("Bal de fin d'annee",LocalDate.parse("2023-07-28"), LocalTime.of(23, 0,0));
		Eleve e1 = new Eleve("Baccceli", "Pauline", "pau", "pau", LocalDate.parse("1997-03-18"), 0,maisonService.getById(1));
		Eleve e2 = new Eleve("Gozlan", "Olivier", "oli", "oli", LocalDate.parse("1992-03-18"), 0,maisonService.getById(4));
		List<Eleve> participant = new ArrayList();
		participant.add(e1);
		participant.add(e2);
		event.setParticipants(participant);
		evenementService.create(event);
		eleveService.create(e1);
		eleveService.create(e2);
		System.out.println(event);
		System.out.println(participant);
		
	}
	@Disabled
	@Test
	void evenementServiceTest() {
		assertNotNull(evenementService);
	}
}
