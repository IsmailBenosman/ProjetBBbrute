package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.exception.MaisonException;
import sopraprojet.harrypotter.service.MaisonService;

@RestController
@RequestMapping("/api/maison")
public class MaisonRestController {

	@Autowired
	private MaisonService maisonService;
	
	@JsonView(JsonViews.MaisonWithCompte.class)
	@GetMapping("")
	public List<Maison> getAll() {
		return maisonService.getAll();
	}
	
	@JsonView(JsonViews.MaisonWithCompte.class)
	@GetMapping("/{id}")
	public Maison getById(@PathVariable Integer id) {
		return maisonService.getByIdWithCompte(id);
	}
	
	private Maison save(Maison activite, BindingResult br) {
		if (br.hasErrors()) {
			throw new MaisonException();
		}
		return maisonService.save(activite);
	}
	
	@PutMapping("/{id}")
	@JsonView(JsonViews.MaisonWithCompte.class)
	public Maison update(@PathVariable Integer id, @Valid @RequestBody Maison maison, BindingResult br) {
		maison.setId(id);
		return save(maison, br);
	}

	
	
	
}
