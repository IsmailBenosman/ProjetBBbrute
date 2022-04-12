package sopraprojet.harrypotter.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.Maison;




public interface EleveRepository extends JpaRepository<Eleve, Integer>{
	@Query("select e from Eleve e left join fetch e.mesCours where e.id=:id")
	Optional<Eleve> findByIdWithModule(Integer id);

	List<Eleve> findByMaison(Maison m);
	List<Eleve> findByCours(Cours cours);
	
	//@Query("select id_eleve from cours_des_eleves where cours_des_eleves.cours =:id")
	//List<Eleve>  findEleveByIdCours(Integer id);
	/*	
	

	
	List<Eleve> findEleveByIdCours(Integer id);
	
	@Query(value = "SELECT * FROM cours_des_eleves WHERE cours = :cours", nativeQuery = true)
	List<Eleve> findByCoursquery(Integer id);
*/
}
