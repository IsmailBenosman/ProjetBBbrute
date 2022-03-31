package sopraprojet.harrypotter.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import sopraprojet.harrypotter.event.Evenement;



public interface EvenementRepository extends JpaRepository<Evenement, Integer>{
	
	
	
		
}
