package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.exception.CompteException;
import sopraprojet.harrypotter.repositories.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepository;
	

	public void create(Compte c) {
		if (c.getId() != null) {
			// probl�me
			throw new CompteException("");
		}
		if (c.getLogin().isEmpty()) {
			throw new CompteException("Login manquant");
		}
		if (c.getPassword().isEmpty()) {
			throw new CompteException("Mot de passe manquant");
		}
		compteRepository.save(c);
	}

	public void update(Compte c) {
		if (c.getId() == null) {
			throw new CompteException("");
		}
		if (c.getLogin().isEmpty()) {
			throw new CompteException("Login manquant");
		}
		if (c.getPassword().isEmpty()) {
			throw new CompteException("Mot de passe manquant");
		}
		compteRepository.save(c);
	}

	public List<Compte> getAll() {
		return compteRepository.findAll();
	}

	public Compte getById(Integer id) {
		return compteRepository.findById(id).orElseThrow(() -> {
			throw new CompteException("numero inconnu");
		});
	}


	public void delete(Compte c) {

		compteRepository.delete(c);
	}
	public void delete(Integer id) {
		compteRepository.deleteById(id);
	}
	
	public Compte save(Compte comptc) {
		if (comptc.getId() != null) {
			Compte compteEnBase = getById(comptc.getId());
			comptc.setVersion(compteEnBase.getVersion());
		}
		return compteRepository.save(comptc);
	}

}