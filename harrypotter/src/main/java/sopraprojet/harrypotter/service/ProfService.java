package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.exception.ProfException;
import sopraprojet.harrypotter.repositories.ProfRepository;



@Service
public class ProfService {

	@Autowired
	private ProfRepository profRepository;
	
	/*
	 * public Prof insert(Prof pf) { EntityManager em =
	 * Context.getSingleton().getEmf().createEntityManager();
	 * em.getTransaction().begin(); em.persist(pf); em.getTransaction().commit();
	 * em.close(); return null;
	 
		
	}	*/
	public void create(Prof pf) {
		if (pf.getId() != null) {
			throw new ProfException("l'id ne doit pas etre defini");
		}
		if (pf.getLogin() == null || pf.getLogin().isEmpty()) {
			throw new ProfException("Login manquant");
		}
		if (pf.getPassword() == null || pf.getLogin().isEmpty()) {
			throw new ProfException("Password manquant");
		}
		profRepository.save(pf);
	}

	public void update(Prof pf) {
		if (pf.getId() == null) {
			throw new ProfException("le numero doit etre defini");
		}
		if (pf.getLogin() == null ||pf.getLogin().isEmpty()) {
			throw new ProfException("Login manquant");
		}
		profRepository.save(pf);
	}

	public List<Prof> getAll() {
		return profRepository.findAll();
	}

	public Prof getById(Integer id) {
		return profRepository.findById(id).orElseThrow(() -> {
			throw new ProfException("id inconnu");
		});
	}

	/*public Prof getByNumeroWithReservation(Integer id) {
		return ProfRepository.findByNumeroWithReservations(numero).orElseThrow(() -> {
			throw new ClientException("numero inconnu");
		});
	}*/

	public void delete(Prof pf) {
//		Client clientEnBaseAvecReservations = getByNumeroWithReservation(c.getNumero());
//		reservationRepository.deleteAll(clientEnBaseAvecReservations.getReservations());
//		clientRepository.delete(clientEnBaseAvecReservations);

		Prof profEnBase = getById(pf.getId());
		//profRepository.deleteByProf(profEnBase);
		profRepository.delete(profEnBase);
	}

	public void deleteByNumero(Integer id) {
		Prof prof = new Prof();
		prof.setId(id);
		delete(prof);
	}
}
