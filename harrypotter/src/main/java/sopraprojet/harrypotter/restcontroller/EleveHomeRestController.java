package sopraprojet.harrypotter.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.ecole.InscriptionCours;
import sopraprojet.harrypotter.ecole.Modules;
import sopraprojet.harrypotter.service.CoursService;
import sopraprojet.harrypotter.service.EleveService;
import sopraprojet.harrypotter.service.InscriptionCoursService;
import sopraprojet.harrypotter.service.ModuleService;

@RestController
@RequestMapping("/api/home/eleve")
public class EleveHomeRestController {

	@Autowired
	private ModuleService moduleService;
	@Autowired
	private EleveService eleveService;
	@Autowired
	private CoursService coursService;
	@Autowired
	private InscriptionCoursService inscriptionS;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/bulletin/{id}")
	public List<Modules> getAllById(@PathVariable Integer id) {
		Eleve e = eleveService.getById(id);
		return moduleService.findModuleWithEleve(e);
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping("/eleve/{id}") 
	public List<InscriptionCours> getAllByEleve(@PathVariable Integer id) {
		Eleve eleve = eleveService.getById(id);
		return inscriptionS.findByEleve(eleve);
	}
}
