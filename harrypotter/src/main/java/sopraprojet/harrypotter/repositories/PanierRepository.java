package sopraprojet.harrypotter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.compte.Compte;

public interface PanierRepository extends JpaRepository<Panier, Integer>{
	

	public List<Panier> findByCompte(Compte compte);
	
	
	public List<Panier> findByCompteAndAchatTrue(Compte compte);
	public List<Panier> findByComptePanierAndAchatFalse(Compte compte);
}
