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
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.exception.EleveException;
import sopraprojet.harrypotter.repositories.EleveRepository;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.ProfService;
@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins="*")
public class AdminHomeRestController {


		@Autowired
		EleveRepository eleveRepo;
		@Autowired
		EleveService eleveService;
		@Autowired
		ProfService profService;
		@Autowired 
		CoursService coursService;
		
		@JsonView(JsonViews.Maison.class)
		@GetMapping("/listeeleve")
		public List<Eleve> lesEleves() {
			return eleveService.getAll();
		}
		@JsonView(JsonViews.Common.class)
		@GetMapping("/geteleve/{id}")
		public Eleve getById(@PathVariable Integer id) {
			return eleveService.getById(id);
		}
		@JsonView(JsonViews.Common.class)
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		@DeleteMapping("/deleteeleve/{id}")
		public void delete(@PathVariable Integer id) {
			eleveService.delete(id);
		}
		@JsonView(JsonViews.Common.class)
		private Eleve createOrUpdate(Eleve eleve, BindingResult br) {
			if (br.hasErrors()) {
				throw new EleveException();
			}
			return eleveService.save(eleve);
		}
		
		@JsonView(JsonViews.Common.class)
		@PostMapping("/editeleve")
		@ResponseStatus(code = HttpStatus.CREATED)
		public Eleve create(@Valid @RequestBody Eleve eleve, BindingResult br) {
			return createOrUpdate(eleve, br);
		}

		@PutMapping("/update/{id}")
		public Eleve update(@PathVariable Integer id, @Valid @RequestBody Eleve eleve, BindingResult br) {
			eleve.setId(id);
			return save(eleve, br);
		}

		private Eleve save(Eleve eleve, BindingResult br) {
			if (br.hasErrors()) {
				throw new EleveException();
			}
			return eleveService.save(eleve);
		}
		
//
		
		@JsonView(JsonViews.Maison.class)
		@GetMapping("/listeprof")
		public List<Prof> lesProf() {
			return profService.getAll();
		}
		@JsonView(JsonViews.Common.class)
		@GetMapping("/getprof/{id}")
		public Prof getByIdprof(@PathVariable Integer id) {
			return profService.getById(id);
		}
		@JsonView(JsonViews.Common.class)
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		@DeleteMapping("/deleteprof/{id}")
		public void deleteprof(@PathVariable Integer id) {
			eleveService.delete(id);
		}
		@JsonView(JsonViews.Common.class)
		private Prof createOrUpdate(Prof prof, BindingResult br) {
			if (br.hasErrors()) {
				throw new EleveException();
			}
			return profService.save(prof);
		}
		
		@JsonView(JsonViews.Common.class)
		@PostMapping("/editprof")
		@ResponseStatus(code = HttpStatus.CREATED)
		public Prof create(@Valid @RequestBody Prof prof, BindingResult br) {
			return createOrUpdate(prof, br);
		}

		@PutMapping("/updateprof/{id}")
		public Prof updateprof(@PathVariable Integer id, @Valid @RequestBody Prof prof, BindingResult br) {
			prof.setId(id);
			return profService.save(prof);
		}
		
		@JsonView(JsonViews.Maison.class)
		@GetMapping("/listecours")
		public List<Cours> lesCours() {
			return coursService.getAll();
		}
		
		@JsonView(JsonViews.Common.class)
		@GetMapping("/getcours/{id}")
		public Cours getByIdcours(@PathVariable Integer id) {
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
		public Cours create(@Valid @RequestBody Cours cours) {
			return coursService.create(cours);
		}
		
		@PutMapping("editcours/{id}")
		@JsonView(JsonViews.Common.class)
		public Cours update(@PathVariable Integer id, @Valid @RequestBody Cours cours, BindingResult br) {
			cours.setId(id);
			return coursService.create(cours);
			
		}

		
}

