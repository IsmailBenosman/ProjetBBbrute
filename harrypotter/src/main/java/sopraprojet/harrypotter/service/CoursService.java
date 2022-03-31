package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.ModuleException;
import module.Cours;
import repositories.CoursRepository;


@Service
public class CoursService {

	@Autowired
	private CoursRepository coursRepository;

	public void create(Cours e) {
		coursRepository.save(e);
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

}