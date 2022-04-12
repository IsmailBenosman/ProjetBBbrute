package sopraprojet.harrypotter.service;


import sopraprojet.harrypotter.boutique.Livraison;
import sopraprojet.harrypotter.repositories.LivraisonRepository;
import sopraprojet.harrypotter.repositories.LivraisonRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivraisonService {

	@Autowired
	private LivraisonRepository livraisonRepository;


	public List<Livraison> getAll() {
		return livraisonRepository.findAll();
	}
	
	public Livraison getById(Integer id) {
		return livraisonRepository.getById(id);
	}



}