package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.exception.BoutiqueException;
import sopraprojet.harrypotter.exception.MaisonException;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.MaisonService;

@RestController
@RequestMapping("/api/maison")
@CrossOrigin(origins="*")
public class MaisonRestController {

	@Autowired
	private MaisonService maisonService;

	@Autowired
	private EleveService eleveService;

	@JsonView(JsonViews.Maison.class)
	@GetMapping("")
	public List<Maison> getAllMaisonWithScoreTotal() {
		List<Maison> maisons = maisonService.getAll();
		for (Maison h : maisons) {
			int scoreMaison = 0;
			List<Eleve> eleves = eleveService.getAll();
			
			for (Eleve e : eleves) {
				int totalNotes = 0;
				if (h.getNom().equals(e.getMaison().getNom())) {
					List<Modules> modules = e.getMesCours();
					for (Modules mod : modules) {
						totalNotes += mod.getNote();
					}
				}scoreMaison += totalNotes;
			}			
			h.setScore(scoreMaison);
			maisonService.save(h);
		}
		return maisonService.getAll();
	}

	@JsonView(JsonViews.Maison.class)
	@GetMapping("/{id}")
	public Maison getById(@PathVariable Integer id) {
		return maisonService.getById(id);
	}

	private Maison save(Maison maison, BindingResult br) {
		if (br.hasErrors()) {
			throw new MaisonException();
		}
		return maisonService.save(maison);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Maison.class)
	public Maison update(@PathVariable Integer id, @Valid @RequestBody Maison maison, BindingResult br) {
		maison.setId(id);
		return save(maison, br);
	}
	@JsonView(JsonViews.Maison.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Maison create(@Valid @RequestBody Maison maison, BindingResult br) {
		return createOrUpdate(maison, br);
	}
	private Maison createOrUpdate(Maison maison, BindingResult br) {
		if (br.hasErrors()) {
			throw new BoutiqueException();
		}
		return maisonService.save(maison);
	}
}
