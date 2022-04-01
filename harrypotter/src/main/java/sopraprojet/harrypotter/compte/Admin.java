package sopraprojet.harrypotter.compte;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import sopraprojet.harrypotter.maison.Maison;

@Entity
@DiscriminatorValue("admin")
@Table(name="admin")
public class Admin extends Compte{

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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
				+ ", naissance=" + naissance + ", solde=" + solde + ", img=" + img + "]";
	}


	
}
