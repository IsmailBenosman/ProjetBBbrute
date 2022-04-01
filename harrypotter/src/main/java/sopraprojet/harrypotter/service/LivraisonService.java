package sopraprojet.harrypotter.service;

import sopraprojet.harrypotter.boutique.Livraison;
import sopraprojet.harrypotter.repositories.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivraisonService {

	@Autowired
	private LivraisonRepository livraisonRepository;

	public void create(Livraison livraison) {
		//TODO: creates new data without checking for duplicates
		livraisonRepository.save(livraison);
	}

	public void delete(Integer id) {
		livraisonRepository.delete(getById(id));
	}

	public Livraison getById(Integer id) {
		return livraisonRepository.findById(id).orElseThrow(RuntimeException::new);
	}
}
