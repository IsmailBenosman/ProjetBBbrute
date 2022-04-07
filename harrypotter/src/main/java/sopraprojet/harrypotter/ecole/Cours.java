package sopraprojet.harrypotter.ecole;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Prof;

@Entity
@DiscriminatorValue("cours")
@Table(name = "cours")
public class Cours {
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="cours")
	private String intitule;

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn(name="professeur")
	private Prof professeur;

	@JsonView(JsonViews.Common.class)
	@OneToOne
	@JoinColumn(name="module")
	private Modules module;

	public Cours() {
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

	public Modules getModule() {
		return module;
	}

	public void setModule(Modules module) {
		this.module = module;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", intitule=" + intitule + ", professeur=" + professeur + ", module=" + module + "]";
	}

}
