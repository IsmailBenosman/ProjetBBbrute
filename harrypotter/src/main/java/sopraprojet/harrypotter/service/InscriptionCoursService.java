package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.exception.InscriptionCoursException;
import sopraprojet.harrypotter.exception.ModuleException;
import sopraprojet.harrypotter.module.Cours;
import sopraprojet.harrypotter.module.InscriptionCours;
import sopraprojet.harrypotter.repositories.InscriptionCoursRepository;

@Service
public class InscriptionCoursService {

	@Autowired
	InscriptionCoursRepository inscriptioncoursRepository;
	
	public void create(InscriptionCours e) {
		inscriptioncoursRepository.save(e);
	}

	public void update(InscriptionCours e) {
		inscriptioncoursRepository.save(e);
	}

	public List<InscriptionCours> getAll() {
		return inscriptioncoursRepository.findAll();
	}

	public InscriptionCours getById(Integer id) {
		return inscriptioncoursRepository.findById(id).orElseThrow(() -> {
			throw new InscriptionCoursException("numero inconnu");
		});
	}
	
	public void delete(InscriptionCours e) {
		inscriptioncoursRepository.delete(e);
	}
	
	public List<InscriptionCours> findEleveByCours(Cours crs) {
		return inscriptioncoursRepository.findEleveByCours(crs);
	}
}