package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ModuleException;
import module.Modules;
import repositories.ModuleRepository;

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

}