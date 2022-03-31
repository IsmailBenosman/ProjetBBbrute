package compte;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import module.Cours;

@Entity
@DiscriminatorValue("prof")
@Table(name="prof")
public class Prof  extends Compte{
	
	@OneToMany(mappedBy="module")
	private List<Cours> uE;
	
	public Prof() {
	
	}
	public Prof(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			String maison) {
		super(nom, prenom, login, password, naissance, solde,maison);
	}

		public List<Cours> getuE() {
		return uE;
	}
	public void setuE(List<Cours> uE) {
		this.uE = uE;
	}

		

	}
