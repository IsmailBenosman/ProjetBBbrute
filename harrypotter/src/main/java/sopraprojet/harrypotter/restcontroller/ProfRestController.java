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
import sopraprojet.harrypotter.compte.Compte;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.exception.ProfException;
import sopraprojet.harrypotter.repositories.ProfRepository;
import sopraprojet.harrypotter.service.ProfService;

@RestController
@RequestMapping("/api/prof")
@CrossOrigin(origins="*")
public class ProfRestController {

	@Autowired
	ProfRepository ProfRepo;
	@Autowired
	ProfService profService;
	
	@JsonView(JsonViews.Maison.class)
	@GetMapping("")
	public List<Prof> getProf() {
		return profService.getAll();
	}
	@JsonView(JsonViews.Maison.class)
	@GetMapping("/{id}")
	public Prof getById(@PathVariable Integer id) {
		return profService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		profService.delete(id);
	}

	private Prof createOrUpdate(Prof prof, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProfException();
		}
		return profService.save(prof);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Prof create(@Valid @RequestBody Prof prof, BindingResult br) {
		
		return createOrUpdate(prof, br);
	}
	@JsonView(JsonViews.Maison.class)
	@PutMapping("/{id}")
	public Prof update(@PathVariable Integer id, @Valid @RequestBody Prof prof, BindingResult br) {
		prof.setId(id);
		return save(prof, br);
	}

	private Prof save(Prof prof, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProfException();
		}
		return profService.save(prof);
	}

}
