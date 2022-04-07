package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.exception.ModuleException;
import sopraprojet.harrypotter.repositories.EvenementRepository;


@Service
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepository;


	public void create(Evenement e) {
		evenementRepository.save(e);
	}

	public List<Evenement> getAll() {
		return evenementRepository.findAll();
	}

	public Evenement getById(Integer id) {
		return evenementRepository.findById(id).orElseThrow(() -> {
			throw new ModuleException("numero inconnu");
		});
	}

	public void delete(Evenement e) {
		delete(e.getId());
	}

	public void delete(Integer id) {
		evenementRepository.deleteById(id);
	}

	public Evenement save(Evenement evenement) {
		if (evenement.getId() != null) {
			Evenement event = getById(evenement.getId());
			evenement.setVersion(event.getVersion());
		}
		return evenementRepository.save(evenement);

	}

}