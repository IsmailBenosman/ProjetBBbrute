package sopraprojet.harrypotter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Cours;


public interface CoursRepository extends JpaRepository<Cours, Integer>{
	
	/*@Query("delete prof from Cours cours where cours.prof=:prof")
	void deleteByProf(@Param("prof") Prof prof);*/

		
}
