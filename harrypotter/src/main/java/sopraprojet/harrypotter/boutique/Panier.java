package sopraprojet.harrypotter.boutique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import sopraprojet.harrypotter.compte.Compte;

@Entity
@Table(name = "panier")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Column(name = "quantite", nullable = false)
	private int quantite;

	@ManyToOne
	@JoinColumn(name = "compte_id")
	private Compte compte;

	
	//si achat est true,  ce produit est acheté, sinon c'est qu'il est en attente dans le panier
	private boolean achat = false; 

	@ManyToOne
	@JoinColumn(name = "article_id")
	private Produit article;

	@Version
	private int version;

	public Panier() {
	}

	public Produit getArticle() {
		return article;
	}

	public void setArticle(Produit article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getArticles() {
		return article;
	}

	public void setArticles(Produit article) {
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

	public boolean isAchat() {
		return achat;
	}

	public void setAchat(boolean achat) {
		this.achat = achat;
	}

	


}
