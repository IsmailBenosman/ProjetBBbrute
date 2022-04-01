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

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.entity.Role;
import sopraprojet.harrypotter.event.Evenement;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.module.InscriptionCours;
import sopraprojet.harrypotter.module.Modules;

@Entity
@DiscriminatorValue("eleve")
@Table(name = "eleve")
public class Eleve  extends Compte{
	

  	public Eleve(Integer id, String nom, String prenom, String login, String password, LocalDate naissance,
			double solde, Maison maison) {
		super(id, nom, prenom, login, password, naissance, solde, maison);
		// TODO Auto-generated constructor stub
	}





	public Eleve(Integer id, @NotEmpty(message = "Champ obligatoire") String nom,
			@NotEmpty(message = "Champ obligatoire") String prenom,
			@NotEmpty(message = "Champ obligatoire") String login,
			@NotEmpty(message = "Champ obligatoire") String password, @Past LocalDate naissance, double solde,
			String img, Maison maison, Panier panier, Set<Role> roles) {
		super(id, nom, prenom, login, password, naissance, solde, img, maison, panier, roles);
		// TODO Auto-generated constructor stub
	}





	public Eleve(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		super(nom, prenom, login, password, naissance, solde, maison);
		// TODO Auto-generated constructor stub
	}

	@OneToMany(mappedBy = "eleve")
	private List<Modules> mesCours;

  	@ManyToMany(mappedBy="participants")
  	private List<Evenement> event;

  	@OneToMany(mappedBy="eleve")
  	private List<InscriptionCours> inscription;
  	
  	public Eleve() {
		// TODO Auto-generated constructor stub
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

	public List<InscriptionCours> getEleve() {
		return inscription;
	}

	public void setEleve(List<InscriptionCours> inscription) {
		this.inscription = inscription;
	}


	

}
	
	
	
	
	
	
	



