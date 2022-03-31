package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import compte.Eleve;


public interface EleveRepository extends JpaRepository<Eleve, Integer>{
	

	@Query("select e from Eleve e left join fetch e.mesCours where e.id=:id")
	Optional<Eleve> findByIdWithModule(Integer id);
	
		
}
