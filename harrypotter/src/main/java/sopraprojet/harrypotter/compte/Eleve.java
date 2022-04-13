package sopraprojet.harrypotter.compte;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.ecole.Maison;
import sopraprojet.harrypotter.ecole.Modules;

@Entity
@DiscriminatorValue("eleve")
@Table(name = "eleve")
public class Eleve extends Compte {

	//@Cascade(CascadeType.DELETE)
	@OneToMany(mappedBy = "eleve")
	private List<Modules> mesCours;
	
	//@Cascade(CascadeType.DELETE)
	/*
	 * @ManyToMany(mappedBy = "participants") private List<Evenement> event;
	 * 
	 */
	@JsonView(JsonViews.Common.class)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name="cours_des_eleves",
			joinColumns = @JoinColumn(name="id_eleve"),
			inverseJoinColumns = @JoinColumn(name="cours")
			)
	private List<Cours> cours;
	
	public Eleve() {

	}

	public Eleve(Integer id, String nom, String prenom, String login, String password, LocalDate naissance,
			double solde, Maison maison) {
		super(id, nom, prenom, login, password, naissance, solde, maison);

	}

	public Eleve(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		super(nom, prenom, login, password, naissance, solde, maison);
	}

	public List<Modules> getMesCours() {
		return mesCours;
	}

	public void setMesCours(List<Modules> mesCours) {
		this.mesCours = mesCours;
	}

	public String getIdentite() {
		return nom + " " + prenom;
	}

	/*
	 * public List<Evenement> getEvent() { return event; }
	 * 
	 * public void setEvent(List<Evenement> event) { this.event = event; }
	 */

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	

}
