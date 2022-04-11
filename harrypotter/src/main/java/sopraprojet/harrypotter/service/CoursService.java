package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.exception.ModuleException;
import sopraprojet.harrypotter.repositories.CoursRepository;


@Service
public class CoursService {

	@Autowired
	private CoursRepository coursRepository;

	public Cours create(Cours e) {
		return coursRepository.save(e);
	}

	public void update(Cours e) {
		coursRepository.save(e);
	}

	public List<Cours> getAll() {
		return coursRepository.findAll();
	}

	public Cours getById(Integer id) {
		return coursRepository.findById(id).orElseThrow(() -> {
			throw new ModuleException("numero inconnu");
		});
	}
	
	public void delete(Cours e) {
		coursRepository.delete(e);
	}
	
	public void deletebById(Integer id) {
		coursRepository.deleteById(id);
	}
	/*
	public List<Cours> getbyprof(Integer id) {
		return coursRepository.findByprof(id);
	}
	*/
	


	public Cours save(Cours coursAAjouter) {
		return coursRepository.save(coursAAjouter);
	}
	
		
	

}