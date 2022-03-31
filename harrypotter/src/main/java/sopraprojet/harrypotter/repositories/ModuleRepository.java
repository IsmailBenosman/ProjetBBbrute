package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import compte.Eleve;
import module.Modules;

public interface ModuleRepository extends JpaRepository<Modules,Integer>{
	
	@Query("delete from Modules modules where modules.eleve=:eleve")
	void deleteByEleve(@Param("eleve") Eleve eleve);
	
}
