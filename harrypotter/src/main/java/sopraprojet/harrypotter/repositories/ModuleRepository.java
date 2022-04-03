package sopraprojet.harrypotter.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Modules;



public interface ModuleRepository extends JpaRepository<Modules,Integer>{
	
	@Query("delete from Modules modules where modules.eleve=:eleve")
	void deleteByEleve(@Param("eleve") Eleve eleve);

	List<Module> findByEleve(Eleve e);
	
}
