package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.exception.PanierException;
import sopraprojet.harrypotter.repositories.PanierRepository;

@Service
public class PanierService {

	@Autowired
	private PanierRepository panierRepository;
	

	public List<Panier> getAll() {
		return panierRepository.findAll();
	}

	public Panier getById(Integer id) {
		return panierRepository.findById(id).orElseThrow(PanierException::new);
	}

	public Panier save(Panier panier) {
		if (panier.getId() != null) {
			Panier panierEnBase = getById(panier.getId());
			panier.setVersion(panierEnBase.getVersion());
		}
		return panierRepository.save(panier);
	}

	public void delete(Panier vehicule) {
		delete(vehicule.getId());
	}

	public void delete(Integer id) {
		panierRepository.deleteById(id);
	}

	public Panier getByIdWithCompte(Integer id) {
		return panierRepository.findByIdWithCompte(id).orElseThrow(PanierException::new);
	}
}
