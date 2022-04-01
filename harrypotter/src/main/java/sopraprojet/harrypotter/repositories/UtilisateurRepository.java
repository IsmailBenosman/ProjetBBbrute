package sopraprojet.harrypotter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sopraprojet.harrypotter.entity.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Optional<Utilisateur> findByLogin(String login);
}
