package sopraprojet.harrypotter.compte;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.ecole.Cours;
import sopraprojet.harrypotter.ecole.Maison;

@Entity
@DiscriminatorValue("prof")
@Table(name = "prof")
public class Prof extends Compte {

	//@Cascade(CascadeType.REMOVE)
	@OneToMany(mappedBy = "professeur")
	private List<Cours> uE;

	public Prof() {

	}

	public Prof(Integer id, String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		super(id, nom, prenom, login, password, naissance, solde, maison);
		// TODO Auto-generated constructor stub
	}

	public Prof(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		super(nom, prenom, login, password, naissance, solde, maison);
	}

	public List<Cours> getuE() {
		return uE;
	}

	public void setuE(List<Cours> uE) {
		this.uE = uE;
	}

}
