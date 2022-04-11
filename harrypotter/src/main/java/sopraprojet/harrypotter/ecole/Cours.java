package sopraprojet.harrypotter.ecole;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;

@Entity
@DiscriminatorValue("cours")
@Table(name = "cours")
public class Cours {
<<<<<<< HEAD
	
	@JsonView(JsonViews.Common.class)
=======
	@JsonView(JsonViews.Cours.class)
>>>>>>> main
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
<<<<<<< HEAD
	@JsonView(JsonViews.Common.class)
=======
	@JsonView(JsonViews.Cours.class)
>>>>>>> main
	@Column(name="cours")
	private String intitule;

	@JsonView(JsonViews.CoursWithProf.class)
	@ManyToOne
	@JoinColumn(name="professeur")
	private Prof professeur;
	
	@JsonView(JsonViews.CoursWithEleves.class)
	@ManyToMany(mappedBy = "cours")
	private List<Eleve> eleve;

	
	
	
	public Cours() {
	}
	public Cours(String intitule, Prof professeur, Modules module) {
		
		this.intitule = intitule;
		this.professeur = professeur;
		this.module = module;
	}


	public Cours(Integer id, String intitule, Prof professeur) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.professeur = professeur;
	}

	public Cours(String intitule, Prof professeur) {
		this.intitule = intitule;
		this.professeur = professeur;
	}

	public Cours(String intitule) {
		super();
		this.intitule = intitule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Prof getProfesseur() {
		return professeur;
	}

	public void setProfesseur(Prof professeur) {
		this.professeur = professeur;
	}

	public List<Eleve> getEleve() {
		return eleve;
	}

	public void setEleve(List<Eleve> eleve) {
		this.eleve = eleve;
	}



}
