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

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Compte;

@Entity
@Table(name = "panier")
public class Panier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(JsonViews.Common.class)
	protected Integer id;

	@JsonView(JsonViews.Common.class)
	@Column(name = "quantite", nullable = false)
	private int quantite;

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	@JoinColumn(name = "compte_id")
	private Compte compte;

	@JsonView(JsonViews.Common.class)
	//si achat est true,  ce produit est acheté, sinon c'est qu'il est en attente dans le panier
	private boolean achat = false; 

	@ManyToOne
	@JoinColumn(name = "article_id")
	@JsonView(JsonViews.Common.class)
	private Produit articles;

	@JsonView(JsonViews.Common.class)
	@Version
	private int version;

	public Panier() {
	}

	

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getArticles() {
		return articles;
	}

	public void setArticles(Produit article) {
		this.articles = article;
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
