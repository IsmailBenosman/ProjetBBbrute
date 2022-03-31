package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import sopraprojet.harrypotter.exception.MaisonException;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.repositories.MaisonRepository;

public class MaisonService {


	@Autowired
	private MaisonRepository maisonRepository;
	

	public void create(Maison e) {
		if (e.getId() != null) {
			// probl�me
			throw new MaisonException("l'id ne doit pas etre d�fini");
		}
		
		maisonRepository.save(e);
	}

	public void update(Maison e) {
		if (e.getId() == null) {
			throw new MaisonException("l'id doit pas etre d�fini");
		}
	
		maisonRepository.save(e);
	}

	public List<Maison> getAll() {
		return maisonRepository.findAll();
	}

	public Maison getById(Integer id) {
		return maisonRepository.findById(id).orElseThrow(() -> {
			throw new MaisonException("numero inconnu");
		});
	}


	public void delete(Maison e) {
	
		maisonRepository.delete(e);
	}
	
	
	public Maison save(Maison e) {
		
		return maisonRepository.save(e);
	}

}
