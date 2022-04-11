package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.InscriptionCours;
import sopraprojet.harrypotter.exception.InscriptionCoursException;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.InscriptionCoursService;

@RestController
@RequestMapping("/api/inscription")
public class InscriptionRestController {

	@Autowired
	private InscriptionCoursService inscriptionService;

	@Autowired
	private CoursService coursService;

	@Autowired
	private EleveService eleveService;

	@JsonView(JsonViews.Common.class)
	@GetMapping("") // getAll inscription : Marche nickel !
	public List<InscriptionCours> getAll() {
		return inscriptionService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/eleve/{id}") // get inscription par eleve(id) : Marche nickel !
	public List<InscriptionCours> getAllByEleve(@PathVariable Integer id) {
		Eleve eleve = eleveService.getById(id);
		return inscriptionService.findByEleve(eleve);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}") // get inscription par id : Marche nickel !
	public InscriptionCours getById(@PathVariable Integer id) {
		return inscriptionService.getById(id);
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/cours/{id}") // get inscription par cours(id) : Marche nickel !
	public List<InscriptionCours> getByCours(@PathVariable Integer id) {
		Cours c = coursService.getById(id);
		return inscriptionService.findByCours(c);
	}

	private InscriptionCours createOrUpdate(InscriptionCours inscription, BindingResult br) {
		if (br.hasErrors()) {
			throw new InscriptionCoursException("Erreur");
		}
		return inscriptionService.save(inscription);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public InscriptionCours update(@PathVariable Integer id, @Valid @RequestBody InscriptionCours inscription,
			BindingResult br) {
		inscription.setId(id);
		return createOrUpdate(inscription, br);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		inscriptionService.deleteById(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Eleve createInscription(@PathVariable Integer id, @Valid @RequestBody InscriptionCours inscription,
			BindingResult br) {
		Eleve eleve = eleveService.getById(id);
		List<Cours> coursEnPlus = eleve.getCours();
		Cours coursAAjouter = inscription.getCours();
		coursEnPlus.add(coursAAjouter);
		List<Eleve> eleves = coursAAjouter.getEleve();
		eleves.add(eleve);
		coursService.save(coursAAjouter);
		createOrUpdate(inscription, br);
		return eleveService.save(eleve);

	}
}
