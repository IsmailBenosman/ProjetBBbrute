package sopraprojet.harrypotter.ecole;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Compte;

@Entity
@Table(name = "maison")
public class Maison {

	@JsonView(JsonViews.Maison.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private String nom;
	@JsonView(JsonViews.Maison.class)
	private int score;
	
	@JsonView(JsonViews.Maison.class)
	@OneToMany(mappedBy="maison",cascade = CascadeType.ALL)
	private List<Compte> comptes;

	public Maison() {
	}

	public Maison(Integer id, String nom, int score) {
		this.id = id;
		this.nom = nom;
		this.score = score;
	}

	public Maison(String nom) {
	this.nom = nom;

	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
