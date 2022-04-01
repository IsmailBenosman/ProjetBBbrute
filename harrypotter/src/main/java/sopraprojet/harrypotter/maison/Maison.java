package sopraprojet.harrypotter.maison;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sopraprojet.harrypotter.compte.Compte;

@Entity
@Table(name = "maison")
public class Maison {

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
	@Id
	private Integer id;
	private String nom;
	private int score;

	@OneToMany(mappedBy="comptes")
	private List<Compte> comptes;

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
