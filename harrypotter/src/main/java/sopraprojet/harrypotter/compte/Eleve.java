package sopraprojet.harrypotter.compte;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.ecole.Evenement;
import sopraprojet.harrypotter.ecole.InscriptionCours;
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
	@ManyToMany(mappedBy = "participants")
	private List<Evenement> event;
	
	//@Cascade(CascadeType.DELETE)
	@OneToMany(mappedBy = "eleve")
	private List<InscriptionCours> inscription;

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

	public List<Evenement> getEvent() {
		return event;
	}

	public void setEvent(List<Evenement> event) {
		this.event = event;
	}

	public List<InscriptionCours> getEleve() {
		return inscription;
	}

	public void setEleve(List<InscriptionCours> inscription) {
		this.inscription = inscription;
	}

	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
				+ ", naissance=" + naissance + ", solde=" + solde + ", img=" + img + "]";
	}

}
