package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.exception.EleveException;
import sopraprojet.harrypotter.repositories.CompteRepository;
import sopraprojet.harrypotter.repositories.EleveRepository;
import sopraprojet.harrypotter.repositories.ModuleRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepository;
	

	public void create(Compte e) {
		if (e.getId() != null) {
			// probl�me
			throw new EleveException("l'id ne doit pas etre d�fini");
		}
		if (e.getLogin().isEmpty()) {
			throw new EleveException("Login manquant");
		}
		if (e.getPassword().isEmpty()) {
			throw new EleveException("Mot de passe manquant");
		}
		compteRepository.save(e);
	}

	public void update(Compte e) {
		if (e.getId() == null) {
			throw new EleveException("l'id doit pas etre d�fini");
		}
		if (e.getLogin().isEmpty()) {
			throw new EleveException("Login manquant");
		}
		if (e.getPassword().isEmpty()) {
			throw new EleveException("Mot de passe manquant");
		}
		compteRepository.save(e);
	}

	public List<Compte> getAll() {
		return compteRepository.findAll();
	}

	

	public void delete(Compte e) {
		compteRepository.delete(e);
	}	
	
	
	public Compte save(Compte e) {
		if (e.getId() != null) {
			Compte cEnBase = getById(e.getId());
			e.setVersion(cEnBase.getVersion());
		}
		return compteRepository.save(e);
	}

	private Compte getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}