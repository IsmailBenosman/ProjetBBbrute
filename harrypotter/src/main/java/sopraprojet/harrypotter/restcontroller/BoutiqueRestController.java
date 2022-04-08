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
import sopraprojet.harrypotter.boutique.Boutique;
import sopraprojet.harrypotter.exception.BoutiqueException;
import sopraprojet.harrypotter.service.BoutiqueService;

@RestController
@RequestMapping("/api/boutiques")
@CrossOrigin(origins="*")
public class BoutiqueRestController {


	@Autowired
	private BoutiqueService boutiqueService;
	
	@JsonView(JsonViews.ProduitWithBoutique.class)
	@GetMapping("")
	public List<Boutique> getAll() {
		return boutiqueService.getAll();
	}
	
	private Boutique createOrUpdate(Boutique boutique, BindingResult br) {
		if (br.hasErrors()) {
			throw new BoutiqueException();
		}
		return boutiqueService.save(boutique);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Boutique create(@Valid @RequestBody Boutique boutique, BindingResult br) {
		return createOrUpdate(boutique, br);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		boutiqueService.delete(id);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Boutique update(@PathVariable Integer id, @Valid @RequestBody Boutique boutique,
			BindingResult br) {
		boutique.setId(id);
		return createOrUpdate(boutique, br);
	}
		
}
