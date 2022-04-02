package sopraprojet.harrypotter.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sopraprojet.harrypotter.compte.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{
	Optional<Compte> findByLogin(String login);
}
