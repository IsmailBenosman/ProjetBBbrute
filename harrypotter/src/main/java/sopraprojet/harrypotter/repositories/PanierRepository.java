package sopraprojet.harrypotter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sopraprojet.harrypotter.boutique.Panier;

public interface PanierRepository extends JpaRepository<Panier, Integer>{

	Optional<Panier> findByIdWithCompte(Integer id);

}
