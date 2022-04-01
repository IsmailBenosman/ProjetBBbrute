package sopraprojet.harrypotter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sopraprojet.harrypotter.repositories.LivraisonRepository;

import sopraprojet.harrypotter.boutique.Livraison;

public interface LivraisonRepository extends JpaRepository<Livraison, Integer>{

		
}
