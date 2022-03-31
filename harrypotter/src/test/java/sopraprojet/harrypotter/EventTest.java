package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import compte.Eleve;
import config.AppConfig;
import event.Evenement;
import service.EleveService;
import service.EvenementService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
class EventTest {
	

	@Autowired
	EvenementService evenementService;
	
	@Autowired
	EleveService eleveService;
	
	@Disabled
	@Test
	@Transactional
	@Commit
	void CreationEventTest() {
		Evenement event = new Evenement("Tournoi des quatre Maisons",LocalDate.parse("2023-07-12"), LocalTime.of(11, 0,0));
		evenementService.create(event);
	}
	
// fonctionne mais ne fait pas la liaison entre les participant et les events dans la tablea event-participant.. 
	@Test
	@Transactional
	@Commit
//	@Rollback
	void CreationEventEleveTest() {
		Evenement event = new Evenement("Bal de fin d'annee",LocalDate.parse("2023-07-28"), LocalTime.of(23, 0,0));
		Eleve e1 = new Eleve("Baccceli", "Pauline", "pau", "pau", LocalDate.parse("1997-03-18"), 0,"Serdaigle");
		Eleve e2 = new Eleve("Gozlan", "Olivier", "oli", "oli", LocalDate.parse("1992-03-18"), 0,"Griffondor");
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
	
	@Test
	void evenementServiceTest() {
		assertNotNull(evenementService);
	}
}
