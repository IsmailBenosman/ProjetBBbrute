package sopraprojet.harrypotter.boutique;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import sopraprojet.harrypotter.compte.Compte;

@Entity
@Table(name = "commande")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "quantite", nullable = false)
	private int quantite;

	@OneToOne
	@JoinColumn(name = "compte_id")
	private Compte compte;

	@OneToMany(mappedBy="panier")
	private List<Produit> article;

	@Version
	private int version;

	public Panier() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public List<Produit> getArticles() {
		return article;
	}

	public void setArticles(List<Produit> article) {
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
