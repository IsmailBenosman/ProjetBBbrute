package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.exception.EvenementException;
import sopraprojet.harrypotter.service.EvenementService;

@RestController
@RequestMapping("/api/evenement")
@CrossOrigin(origins ="*")
public class EventRestController {

	@Autowired
	private EvenementService eventService;


	@JsonView(JsonViews.Common.class)
	@GetMapping("")
	public List<Evenement> getAllEvent() {
		return eventService.getAll();
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public Evenement getById(@PathVariable Integer id) {
		return eventService.getById(id);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		eventService.delete(id);
	}

	private Evenement createOrUpdate(Evenement event, BindingResult br) {
//		if (br.hasErrors()) {
//			throw new EvenementException();
//		}
		return eventService.save(event);
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Evenement create(@Valid @RequestBody Evenement event, BindingResult br) {
		return createOrUpdate(event, br);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Evenement update(@PathVariable Integer id, @Valid @RequestBody Evenement event, BindingResult br) {
		event.setId(id);
		return createOrUpdate(event, br);
		
	}

}
