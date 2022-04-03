package sopraprojet.harrypotter.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Maison;




public interface EleveRepository extends JpaRepository<Eleve, Integer>{
	

	@Query("select e from Eleve e left join fetch e.mesCours where e.id=:id")
	Optional<Eleve> findByIdWithModule(Integer id);

	List<Eleve> findByMaison(Maison m);
	
		
}
