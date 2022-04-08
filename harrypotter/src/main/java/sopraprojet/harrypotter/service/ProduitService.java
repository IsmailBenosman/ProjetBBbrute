package sopraprojet.harrypotter.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.exception.ModuleException;
import sopraprojet.harrypotter.repositories.ProduitRepository;


@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;

	public void create(Produit p) {
		produitRepository.save(p);
	}

	public void update(Produit p) {
		produitRepository.save(p);
	}

	public List<Produit> getAll() {
		return produitRepository.findAll();
	}


	public Produit getById(Integer id) {
		return produitRepository.findById(id).orElseThrow(() -> {
			throw new ModuleException("Produit inconnu");
		});
	}
	
	public void delete(Produit p) {
		delete(p.getId());
	}

	public void delete(Integer id) {
		produitRepository.deleteById(id);
		
	}

	public Produit save(Produit produit) {
		return	produitRepository.save(produit);
	}

	public List<Produit> findAllByBoutique(Boutique b) {
		return	produitRepository.findByBoutique(b);

	}

}