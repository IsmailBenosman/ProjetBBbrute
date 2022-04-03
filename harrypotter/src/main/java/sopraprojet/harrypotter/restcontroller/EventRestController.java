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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.exception.EvenementException;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.EvenementService;
import sopraprojet.harrypotter.service.MaisonService;

@RestController
@RequestMapping("/api/evenement")
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
	@DeleteMapping("/admin/{id}")
	public void delete(@PathVariable Integer id) {
		eventService.delete(id);
	}

	private Evenement createOrUpdate(Evenement event, BindingResult br) {
		if (br.hasErrors()) {
			throw new EvenementException();
		}
		return eventService.save(event);
	}

	@JsonView(JsonViews.Common.class)
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Evenement create(@Valid @RequestBody Evenement event, BindingResult br) {
		return createOrUpdate(event, br);
	}

	@PatchMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Evenement partialUpdate(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		Evenement event = eventService.getById(id);
		fields.forEach((k, v) -> {
			if (k.equals("heure")) {
				List<Integer> heure = (List<Integer>) v;
				event.setHeure(LocalTime.of(heure.get(0), heure.get(1)));
			} else if (k.equals("date")) {
				List<Integer> date = (List<Integer>) v;
				event.setDate(LocalDate.of(date.get(0), date.get(1), date.get(2)));
			} else {
				Field field = ReflectionUtils.findField(Evenement.class, k);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, event, v);
			}
		});
		return eventService.save(event);
	}

}
