package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.exception.ProfException;
import sopraprojet.harrypotter.repositories.CompteRepository;
import sopraprojet.harrypotter.repositories.CoursRepository;
import sopraprojet.harrypotter.repositories.ProfRepository;



@Service
public class ProfService {

	@Autowired
	private ProfRepository profRepository;
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private CoursRepository coursRepo;
	
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

	public void delete(Prof e) {
		profRepository.delete(e);
	}
	public void delete(Integer id) {
		profRepository.deleteById(id);
	}

	public void deleteByNumero(Integer id) {
		Prof prof = new Prof();
		prof.setId(id);
		delete(prof);
	}
	
	public Prof save(Prof prof) {
		if (prof.getId() != null) {
			Prof profEnBase = getById(prof.getId());
			prof.setVersion(profEnBase.getVersion());
		}
		return profRepository.save(prof);
	}
}
