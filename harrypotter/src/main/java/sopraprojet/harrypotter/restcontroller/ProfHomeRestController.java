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
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.exception.EvenementException;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.ModuleService;

@RestController
@RequestMapping("/api/home/prof")
public class ProfHomeRestController {

	@Autowired
	private ModuleService moduleService;
	@Autowired
	private EleveService eleveService;
	@Autowired
	private CoursService coursService;

	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/bulletin/eleve/{id}")
	public List<Modules> getAllById(@PathVariable Integer id) {
		Eleve e = eleveService.getById(id);
		return moduleService.findModuleWithEleve(e);
	}
	private Modules createOrUpdate(Modules modules, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return moduleService.save(modules);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("/createmodule")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Modules create(@Valid @RequestBody Modules modules, BindingResult br) {
		return createOrUpdate(modules, br);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletemodule/{id}")
	public void delete(@PathVariable Integer id) {
		moduleService.delete(id);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/updatemodule/{id}")
	public Modules update(@PathVariable Integer id, @Valid @RequestBody Modules modules,
			BindingResult br) {
		modules.setId(id);
		return createOrUpdate(modules, br);
	}
	

	@JsonView(JsonViews.Maison.class)
	@GetMapping("/listedeseleve")
	public List<Eleve> lesEleves() {
		return eleveService.getAll();
	}
	
	
	@JsonView(JsonViews.Maison.class)
	@GetMapping("/listecours")
	public List<Cours> lesCours() {
		return coursService.getAll();
	}
	/*
	@JsonView(JsonViews.Maison.class)
	@GetMapping("/listeparprof")
	public List<Cours> lesCoursbyprof(Integer id) {
		return coursService.getbyprof(id);
	}
	*/
	@JsonView(JsonViews.Common.class)
	@GetMapping("/getcours/{id}")
	public Cours getcoursById(@PathVariable Integer id) {
		return coursService.getById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletecours/{id}")
	public void deletecours(@PathVariable Integer id) {
		coursService.deletebById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("/createcours")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cours createcours(@Valid @RequestBody Cours cours) {
		return coursService.create(cours);
	}
	
	@PutMapping("/editcours/{id}")
	@JsonView(JsonViews.Common.class)
	public Cours updatecours(@PathVariable Integer id, @Valid @RequestBody Cours cours, BindingResult br) {
		cours.setId(id);
		return coursService.create(cours);
		
	}
	
	
	
	
}
