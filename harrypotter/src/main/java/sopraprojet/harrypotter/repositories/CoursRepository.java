package sopraprojet.harrypotter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Cours;


public interface CoursRepository extends JpaRepository<Cours, Integer>{
	
	/*@Query("delete prof from Cours cours where cours.prof=:prof")
	void deleteByProf(@Param("prof") Prof prof);*/
	List<Cours> findByProfesseur(Prof p);
	
	List<Cours> findByEleve(Eleve eleve);
	
	/*@Query("select c from Cours cours where  = ?1 ")
	public List<Cours> findByprof(Integer id); */
}
