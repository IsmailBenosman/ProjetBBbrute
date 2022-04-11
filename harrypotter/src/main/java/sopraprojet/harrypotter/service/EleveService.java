package sopraprojet.harrypotter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.exception.EleveException;
import sopraprojet.harrypotter.repositories.CompteRepository;
import sopraprojet.harrypotter.repositories.CoursRepository;
import sopraprojet.harrypotter.repositories.EleveRepository;
import sopraprojet.harrypotter.repositories.ModuleRepository;


@Service
public class EleveService {

	@Autowired
	private EleveRepository eleveRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private CompteRepository compteRepo;
	@Autowired
	private CoursRepository coursRepo;
	@Autowired
	private CoursService courss;

	public void create(Eleve e) {
		if (e.getId() != null) {
			// probl�me
			throw new EleveException("l'id ne doit pas etre d�fini");
		}
		if (e.getLogin().isEmpty()) {
			throw new EleveException("Login manquant");
		}
		if (e.getPassword().isEmpty()) {
			throw new EleveException("Mot de passe manquant");
		}
		eleveRepository.save(e);
		Cours point = new Cours("Point de maison",null);
		coursRepo.save(point);
		Modules modulespoint= new Modules(point,0,"Module destiné aux points de maison",e);
		moduleRepository.save(modulespoint);
	}

	public void update(Eleve e) {
		if (e.getId() == null) {
			throw new EleveException("l'id doit pas etre d�fini");
		}
		if (e.getLogin().isEmpty()) {
			throw new EleveException("Login manquant");
		}
		if (e.getPassword().isEmpty()) {
			throw new EleveException("Mot de passe manquant");
		}
		eleveRepository.save(e);
	}

	public List<Eleve> getAll() {
		return eleveRepository.findAll();
	}

	public Eleve getById(Integer id) {
		return eleveRepository.findByIdWithModule(id).orElseThrow(() -> {
			throw new EleveException("numero inconnu");
		});
	}


	public void delete(Eleve e) {
		//moduleRepository.deleteByEleve(e);
		eleveRepository.delete(e);
	}
	public void delete(Integer id) {
		eleveRepository.deleteById(id);
	}
	
	public Eleve save(Eleve eleve) {
		if (eleve.getId() != null) {
			Eleve eleveEnBase = getById(eleve.getId());
			eleve.setVersion(eleveEnBase.getVersion());
		}
		System.out.println("allo?");
		return eleveRepository.save(eleve);
	}

	public List<Eleve> getAllByMaison(Maison m) {
		return eleveRepository.findByMaison(m);
	}

}
