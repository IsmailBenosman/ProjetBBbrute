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
import sopraprojet.harrypotter.boutique.Produit;
import sopraprojet.harrypotter.exception.EvenementException;
import sopraprojet.harrypotter.service.ProduitService;

@RestController
@RequestMapping("/api/catalogue")
public class ProduitRestController {

	
	@Autowired
	private ProduitService produitService;
	
	@JsonView(JsonViews.Produit.class)
	@GetMapping("")
	public List<Produit> getAll() {
		return produitService.getAll();
	}
	
	private Produit createOrUpdate(Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return produitService.save(produit);
	}
	
	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		return createOrUpdate(produit, br);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		produitService.delete(id);
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping("/{id}")
	public Produit update(@PathVariable Integer id, @Valid @RequestBody Produit produit,
			BindingResult br) {
		produit.setId(id);
		return createOrUpdate(produit, br);
	}
		

	
}
