package sopraprojet.harrypotter.boutique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Min;


@Entity
@Table(name="Commande_detail")
public class PanierDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	protected Long id;
	
    @Column(name = "quantite", nullable = false)
    @Min(value = 1)
    private int qte;
	
    private double prixArticle;
 
    @Column(name = "montant", nullable = false)
    private double montant;
	
	@Version
	private int version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public double getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(double prixArticle) {
		this.prixArticle = prixArticle;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
    
    
}
