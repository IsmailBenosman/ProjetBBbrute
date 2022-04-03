package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.InscriptionCours;
import sopraprojet.harrypotter.exception.InscriptionCoursException;
import sopraprojet.harrypotter.repositories.InscriptionCoursRepository;

@Service
public class InscriptionCoursService {

	@Autowired
	InscriptionCoursRepository inscriptioncoursRepository;
	
	public void create(InscriptionCours e) {
		inscriptioncoursRepository.save(e);
	}
	public InscriptionCours save(InscriptionCours inscription) {
		if (inscription.getId() != null) {
			InscriptionCours reservationEnBase = getById(inscription.getId());
			inscription.setVersion(reservationEnBase.getVersion());
		}
		return inscriptioncoursRepository.save(inscription);
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
	
	public void delete(InscriptionCours inscription) {
		inscriptioncoursRepository.delete(inscription);
	}
	
	public void deleteById(Integer id) {
		delete(getById(id));
	}
	
	public List<InscriptionCours> findByCours(Cours crs) {
		return inscriptioncoursRepository.findByCours(crs);
	}
	
	
	
	public List<InscriptionCours> findByEleve(Eleve eleve) {
		return inscriptioncoursRepository.findByEleve(eleve);
	}
	
}