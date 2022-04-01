package sopraprojet.harrypotter.boutique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import sopraprojet.harrypotter.compte.Compte;

@Entity
@Table(name="commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_Commande", initialValue = 100, allocationSize = 1)
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	protected Long id;
	
    @Column(name = "Amount", nullable = false)
    @Min(value = 1)
    private double qte;
	
    @OneToOne
	private Compte compte;
}	
