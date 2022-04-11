package sopraprojet.harrypotter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
	Optional<Compte> findByLogin(String login);
	
	@Query("delete from Compte c where c.id=:prof")
	void deleteByProf(@Param("prof") Prof prof);

	@Query("select c from Compte c left join fetch c.panier where c.id=:id")
	Optional<Compte> findByIdWithPanier(Integer id);
}
