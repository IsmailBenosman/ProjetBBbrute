package sopraprojet.harrypotter.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.boutique.Produit;


public interface ProduitRepository extends JpaRepository<Produit,Integer>  {

	List<Produit> findByBoutique(Boutique b);



}
