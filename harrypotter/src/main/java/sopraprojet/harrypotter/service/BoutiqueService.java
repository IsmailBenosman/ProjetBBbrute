package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boutique.Boutique;
import exception.BoutiqueException;
import repositories.BoutiqueRepository;

@Service
public class BoutiqueService {

	@Autowired
	private BoutiqueRepository boutiqueRepository;


	public void create(Boutique b) {
		boutiqueRepository.save(b);
	}

	public void update(Boutique b) {
		boutiqueRepository.save(b);
	}

	public List<Boutique> getAll() {
		return boutiqueRepository.findAll();
	}
	
	public Boutique getById(Integer id) {
		return boutiqueRepository.findById(id).orElseThrow(BoutiqueException::new);
	}
	
	public Boutique save(Boutique boutique) {
		if (boutique.getId() != null) {
			Boutique boutiqueEnBase = getById(boutique.getId());
			boutique.setVersion(boutiqueEnBase.getVersion());
		}
		return boutiqueRepository.save(boutique);
	}
	
	public void delete(Boutique b) {
		boutiqueRepository.delete(b);
	}
	
	public void deleteById(Integer id) {
		boutiqueRepository.delete(getById(id));
	}
}