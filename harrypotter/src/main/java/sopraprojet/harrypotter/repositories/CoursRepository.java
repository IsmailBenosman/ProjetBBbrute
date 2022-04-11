package sopraprojet.harrypotter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Cours;


public interface CoursRepository extends JpaRepository<Cours, Integer>{
	
	/*@Query("delete prof from Cours cours where cours.prof=:prof")
	void deleteByProf(@Param("prof") Prof prof);*/
	List<Cours> findByProfesseur(Prof p);
	
	/*@Query("select p from cours where prof = ?1 ")
	public List<Cours> findByprof(Integer id); */
}
