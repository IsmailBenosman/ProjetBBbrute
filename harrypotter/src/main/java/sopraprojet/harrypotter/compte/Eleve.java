package sopraprojet.harrypotter.compte;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sopraprojet.harrypotter.event.Evenement;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.module.InscriptionCours;
import sopraprojet.harrypotter.module.Modules;




@Entity
@DiscriminatorValue("eleve")
@Table(name = "eleve")
public class Eleve  extends Compte{
	

  	@OneToMany(mappedBy = "eleve")
	private List<Modules> mesCours;

  	@ManyToMany(mappedBy="participants")
  	private List<Evenement> event;

  	@ManyToMany(mappedBy="presence")
  	private List<InscriptionCours> inscription;
  	
	public Eleve(Integer id, String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
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
		return nom+ " "+prenom;
	}

	public List<Evenement> getEvent() {
		return event;
	}

	public void setEvent(List<Evenement> event) {
		this.event = event;
	}

	public List<InscriptionCours> getInscription() {
		return inscription;
	}

	public void setInscription(List<InscriptionCours> inscription) {
		this.inscription = inscription;
	}
	

}
	
	
	
	
	
	
	



