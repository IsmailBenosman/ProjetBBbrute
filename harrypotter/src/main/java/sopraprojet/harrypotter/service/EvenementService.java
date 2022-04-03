package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.exception.ModuleException;
import sopraprojet.harrypotter.repositories.EvenementRepository;


@Service
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepository;

	public void create(Evenement e) {
		evenementRepository.save(e);
	}

	public void update(Evenement e) {
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
		evenementRepository.delete(e);
	}

	public void delete(Integer id) {

	}

	public Evenement save(Evenement evenement) {
		if (evenement.getId() != null) {
			Evenement eleveEnBase = getById(evenement.getId());
			evenement.setVersion(eleveEnBase.getVersion());
		}
		return evenementRepository.save(evenement);

	}

}