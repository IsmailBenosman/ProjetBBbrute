package sopraprojet.harrypotter.compte;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.maison.Maison;

import sopraprojet.harrypotter.maison.Maison;

@Entity
@DiscriminatorValue("admin")
@Table(name = "admin")
public class Admin extends Compte {

	public Admin() {
	}

	public Admin(Integer id, String nom, String prenom, String login, String password, LocalDate naissance,
			double solde, Maison maison) {
		super(id, nom, prenom, login, password, naissance, solde, maison);
	}

	public Admin(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		super(nom, prenom, login, password, naissance, solde, maison);
	}

}
