package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.exception.ModuleException;
import sopraprojet.harrypotter.repositories.ModuleRepository;

@Service
public class ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	public void create(Modules e) {
		moduleRepository.save(e);
	}

	public void update(Modules e) {
		moduleRepository.save(e);
	}

	public List<Modules> getAll() {
		return moduleRepository.findAll();
	}

	public Modules getById(Integer id) {
		return moduleRepository.findById(id).orElseThrow(() -> {
			throw new ModuleException("numero inconnu");
		});
	}
	
	public void delete(Modules e) {
		moduleRepository.delete(e);
	}
	public List<Modules> findModuleWithEleve(Eleve e) {
		return moduleRepository.findByEleve(e);
	}

	public Modules save(Modules modules) {
		return moduleRepository.save(modules);
	}

	public void delete(Integer id) {
		moduleRepository.delete(getById(id));
		
	}

	public int moyenne(Eleve eleve) {
		return moduleRepository.moyenneByEleve(eleve);
	}
	

}