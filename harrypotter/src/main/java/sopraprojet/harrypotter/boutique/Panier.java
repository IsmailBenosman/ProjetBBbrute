package sopraprojet.harrypotter.boutique;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;

import sopraprojet.harrypotter.compte.Compte;

@Entity
@Table(name="commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_Commande", initialValue = 100, allocationSize = 1)
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	protected Integer id;
	
    @Column(name = "montant", nullable = false)
    @Min(value = 1)
    private double montant;
	
    @OneToOne(mappedBy="panier")
	private Compte compte;
    
    @OneToMany(mappedBy="")
    private List<Produit> articles;
	
	@Version
	private int version;

	public Panier(Integer id, @Min(1) double montant, Compte compte) {
		super();
		this.id = id;
		this.montant = montant;
		this.compte = compte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

    

    
}	
