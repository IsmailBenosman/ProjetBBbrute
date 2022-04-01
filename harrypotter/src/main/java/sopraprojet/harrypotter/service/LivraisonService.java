package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Livraison;
import sopraprojet.harrypotter.exception.BoutiqueException;
import sopraprojet.harrypotter.exception.LivraisonException;
import sopraprojet.harrypotter.repositories.LivraisonRepository;

@Service
public class LivraisonService {

	@Autowired
	private LivraisonRepository livraisonRepository;
	
	public void create(Livraison b) {
		livraisonRepository.save(b);
	}
	
	public Livraison save(Livraison liveraison) {
		if (liveraison.getId() != null) {
			Livraison liveraisonEnBase = getById(liveraison.getId());
			//liveraison.setVersion(liveraisonEnBase.getVersion());
		}
		return livraisonRepository.save(liveraison);
	}

	public List<Livraison> getAll() {
		return livraisonRepository.findAll();
	}
	
	public Livraison getById(Integer id) {
		return livraisonRepository.findById(id).orElseThrow(LivraisonException::new);
	}

}
