package sopraprojet.harrypotter.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.InscriptionCours;

public interface InscriptionCoursRepository extends JpaRepository<InscriptionCours, Integer>{

	public List<InscriptionCours> findByCours(Cours crs);

	public List<InscriptionCours> findByEleve(Eleve eleve);
}
