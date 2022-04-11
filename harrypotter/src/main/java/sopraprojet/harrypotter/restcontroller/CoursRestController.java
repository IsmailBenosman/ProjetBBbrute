package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.ModuleService;

@RestController
@RequestMapping("/api/cours")
@CrossOrigin(origins="*")
public class CoursRestController {

	@Autowired
	CoursService coursService;
	@Autowired 
	ModuleService  moduleService;
	@JsonView(JsonViews.Maison.class)
	@GetMapping("")
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
	@GetMapping("/get/{id}")
	public Cours getById(@PathVariable Integer id) {
		return coursService.getById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		coursService.deletebById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cours create(@Valid @RequestBody Cours cours) {
		return coursService.create(cours);
	}
	
	@PutMapping("/edit/{id}")
	@JsonView(JsonViews.Common.class)
	public Cours update(@PathVariable Integer id, @Valid @RequestBody Cours cours, BindingResult br) {
		cours.setId(id);
		return coursService.create(cours);
		
	}

	
	
	
}
