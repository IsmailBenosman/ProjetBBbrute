package sopraprojet.harrypotter.compte;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.entity.Role;
import sopraprojet.harrypotter.maison.Maison;
import sopraprojet.harrypotter.module.Cours;
@Entity
@DiscriminatorValue("prof")
@Table(name="prof")
public class Prof  extends Compte{
	
	public Prof(Integer id, String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		super(id, nom, prenom, login, password, naissance, solde, maison);
		// TODO Auto-generated constructor stub
	}
	public Prof(Integer id, @NotEmpty(message = "Champ obligatoire") String nom,
			@NotEmpty(message = "Champ obligatoire") String prenom,
			@NotEmpty(message = "Champ obligatoire") String login,
			@NotEmpty(message = "Champ obligatoire") String password, @Past LocalDate naissance, double solde,
			String img, Maison maison,Set<Role> roles) {
		super(id, nom, prenom, login, password, naissance, solde, img, maison, roles);
		// TODO Auto-generated constructor stub
	}
	@OneToMany(mappedBy="module")
	private List<Cours> uE;
	
	public Prof() {
	
	}
	public Prof(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		super(nom, prenom, login, password, naissance, solde,maison);
	}
	
	

		public List<Cours> getuE() {
		return uE;
	}
	public void setuE(List<Cours> uE) {
		this.uE = uE;
	}

		

	}
