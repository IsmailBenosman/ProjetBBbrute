package sopraprojet.harrypotter.restcontroller;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import sopraprojet.harrypotter.exception.EleveException;
import sopraprojet.harrypotter.repositories.EleveRepository;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.ModuleService;


@RestController
@RequestMapping("/api/eleve")
@CrossOrigin(origins="*")
public class EleveRestController {

	@Autowired
	EleveRepository eleveRepo;
	@Autowired
	EleveService eleveService;
	@Autowired
	private ModuleService moduleService;
	
	
	@JsonView(JsonViews.Maison.class)
	@GetMapping("")
	public List<Eleve> lesEleves() {
		return eleveService.getAll();
	}
	@JsonView(JsonViews.Maison.class)
	@GetMapping("/{id}")
	public Eleve getById(@PathVariable Integer id) {
		return eleveService.getById(id);
	}
	
	
	@JsonView(JsonViews.Cours.class)
	@GetMapping("/cours/{id}")
	public Eleve getByIdWithInscription(@PathVariable Integer id) {
		return eleveService.getById(id);
	}
	
	
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		eleveService.delete(id);
	}
	
	
	@JsonView(JsonViews.Common.class)
	private Eleve createOrUpdate(Eleve eleve, BindingResult br) {
//		if (br.hasErrors()) {
//			throw new EleveException();
//		}
		return eleveService.save(eleve);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("/creer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Eleve create(@Valid @RequestBody Eleve eleve, BindingResult br) {
		return createOrUpdate(eleve, br);
	}
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Eleve update(@PathVariable Integer id, @Valid @RequestBody Eleve eleve, BindingResult br) {
		eleve.setId(id);
		return createOrUpdate(eleve, br);
	}

	@PutMapping("/inscriptioncours/{id}")
    @JsonView(JsonViews.Common.class)
    public List<Cours> inscriptioncours(@PathVariable Integer id, @Valid @RequestBody Cours cours) {
        Eleve eleve = eleveService.getById(id);
		List<Cours> listecours= eleve.getCours();
        listecours.add(cours);
        eleve.setCours(listecours);
        eleveService.save(eleve);
        return listecours;
    }

	/*public Eleve inscription(Cours cours) {
		List<Cours> cours_eleve= getCours(); 
		cours_eleve.add(cours);
	}*/
	
	/*@PatchMapping("/{id}")
	public Eleve partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Eleve eleve = eleveService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("heure")) {
				List<Integer> heureRecuperee = (List<Integer>) v;
				eleve.setHeure(LocalTime.of(heureRecuperee.get(0), heureRecuperee.get(1)));
			} else if (k.equals("naissance")) {
				List<Integer> dateRecuperee = (List<Integer>) v;
				eleve.setNaissance(LocalDate.of(dateRecuperee.get(0), dateRecuperee.get(1), dateRecuperee.get(2)));
			} else if (k.equals("vehicule")) {
				if (eleve instanceof Safari) {
					String value = v.toString();

					Vehicule vehicule = new Vehicule();
					vehicule.setId(Integer.parseInt(value.substring(value.indexOf("=") + 1, value.length() - 1)));
					((Safari) eleve).setVehicule(vehicule);
				}
			} else {
				Field field = ReflectionUtils.findField(eleve.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, eleve, v);
			}
		});
		return eleveService.save(eleve);
	}*/
	
}
