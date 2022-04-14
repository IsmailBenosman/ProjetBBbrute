package sopraprojet.harrypotter.service;

import java.util.ArrayList;
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

	@Autowired
	private EleveService eleveService;
	
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
	
//	public void getEleveWithMoyenne(){
//		List moyenne = new ArrayList();
//		List<Modules> modules = getAll();
//		
//		List<Eleve> eleves = eleveService.getAll();
//		for (Eleve el:eleves) {
//			int moy= moyenne(el);
//			moyenne.add(moy);
//		}
//		System.out.println(moyenne);
//	}

}