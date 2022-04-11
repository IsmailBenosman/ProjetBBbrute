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
import sopraprojet.harrypotter.exception.CompteException;
import sopraprojet.harrypotter.repositories.CompteRepository;
import sopraprojet.harrypotter.service.CompteService;

@RestController
@RequestMapping("/api/compte")
@CrossOrigin(origins="*")
public class CompteRestController {
	@Autowired
	CompteRepository compteRepo;
	@Autowired
	CompteService compteService;

	
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Compte> lesComptes() {
		return compteService.getAll();
	}
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Compte getById(@PathVariable Integer id) {
		return compteService.getById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		compteService.delete(id);
	}
	
	
	@JsonView(JsonViews.Common.class)
	private Compte createOrUpdate(Compte compte, BindingResult br) {
		if (br.hasErrors()) {
			throw new CompteException();
		}
		return compteService.save(compte);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("/creer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult br) {
		return createOrUpdate(compte, br);
	}
	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Compte update(@PathVariable Integer id, @Valid @RequestBody Compte compte, BindingResult br) {
		compte.setId(id);
		return createOrUpdate(compte, br);
	}

}
