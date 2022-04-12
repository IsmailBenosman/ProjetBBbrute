package sopraprojet.harrypotter.repositories;

import sopraprojet.harrypotter.boutique.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison, Integer>{
   
}
