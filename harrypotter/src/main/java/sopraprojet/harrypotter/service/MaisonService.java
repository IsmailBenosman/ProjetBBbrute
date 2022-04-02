package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.exception.MaisonException;
import sopraprojet.harrypotter.repositories.MaisonRepository;

@Service
public class MaisonService {


	@Autowired
	private MaisonRepository maisonRepository;
	

	public void create(Maison m) {
		if (m.getId() != null) {
			throw new MaisonException("");
		}
		
		maisonRepository.save(m);
	}

	public void update(Maison m) {
		if (m.getId() == null) {
			throw new MaisonException("l'id doit pas etre d�fini");
		}
	
		maisonRepository.save(m);
	}

	public List<Maison> getAll() {
		return maisonRepository.findAll();
	}

	public Maison getById(Integer id) {
		return maisonRepository.findById(id).orElseThrow(() -> {
			throw new MaisonException("numero inconnu");
		});
	}


	public void delete(Maison m) {
	
		delete(m.getId());
	}
	
	public void delete(Integer id) {
		
		maisonRepository.deleteById(id);
	}
	
	
	public Maison save(Maison m) {
		
		return maisonRepository.save(m);
	}
	
	public Maison getByIdWithCompte (Integer id)
	{
		return maisonRepository.findByIdWithCompte(id);
	}
}

