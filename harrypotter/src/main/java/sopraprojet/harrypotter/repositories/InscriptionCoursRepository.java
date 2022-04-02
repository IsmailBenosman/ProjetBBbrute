package sopraprojet.harrypotter.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.InscriptionCours;

public interface InscriptionCoursRepository extends JpaRepository<InscriptionCours, Integer>{

	@Query("select eleve_fk from InscriptionCours eleve_fk where eleve_fk.cours=:cours")
	public List<InscriptionCours> findEleveByCours(@Param("cours") Cours crs);
}
