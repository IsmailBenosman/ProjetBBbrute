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
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.exception.EvenementException;
import sopraprojet.harrypotter.exception.ModuleException;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.ModuleService;


@RestController
@RequestMapping("/api/bulletin")
@CrossOrigin(origins ="*")
public class ModuleRestController {

	@Autowired
	private ModuleService moduleService;
	@Autowired
	private EleveService eleveService;

	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public List<Modules> getAllById(@PathVariable Integer id) {
		Eleve e = eleveService.getById(id);
		return moduleService.findModuleWithEleve(e);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/eleve/{id}")
	public Modules getById(@PathVariable Integer id) {
		return moduleService.getById(id);
	}
	private Modules createOrUpdate(Modules modules, BindingResult br) {
		if (br.hasErrors()) {
			throw new ModuleException();
		}
		return moduleService.save(modules);
	}
	
	
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Modules create(@Valid @RequestBody Modules modules, BindingResult br) {
		return createOrUpdate(modules, br);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		moduleService.delete(id);
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping("/update/{id}")
	public Modules update(@PathVariable Integer id, @Valid @RequestBody Modules modules,BindingResult br) {
		modules.setId(id);
		return createOrUpdate(modules, br);
	}
	
}
