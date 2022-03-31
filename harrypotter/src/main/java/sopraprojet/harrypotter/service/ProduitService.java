package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.Produit;
import exception.ModuleException;
import exception.ProduitException;
import repositories.ProduitRepository;


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
			throw new ModuleException("numero inconnu");
		});
	}
	
	public void delete(Produit p) {
		produitRepository.delete(p);
	}

}