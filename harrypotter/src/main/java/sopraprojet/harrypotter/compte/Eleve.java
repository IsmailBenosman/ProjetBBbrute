package compte;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import event.Evenement;
import module.Modules;


@Entity
@DiscriminatorValue("eleve")
@Table(name = "eleve")
public class Eleve  extends Compte{
	

  	@OneToMany(mappedBy = "eleve")
	private List<Modules> mesCours;

  	@ManyToMany(mappedBy="participants")
  	private List<Evenement> event;

	public Eleve(Integer id, String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			String maison) {
		super(id, nom, prenom, login, password, naissance, solde, maison);
	}

	public Eleve(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			String maison) {
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
	

}
	
	
	
	
	
	
	



