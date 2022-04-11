package sopraprojet.harrypotter.boutique;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;

@Entity
@Table(name="produit")
public class Produit {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@JsonView(JsonViews.Common.class)
	@ManyToOne
	private Boutique boutique;
	

	@JsonView(JsonViews.Common.class)
	public String libelle; 	
	
	@JsonView(JsonViews.Common.class)
	public double prix;
	
	@JsonView(JsonViews.Common.class)
	private String description;
	
	@JsonView(JsonViews.Common.class)
	private String img;
	
	@OneToMany(mappedBy = "articles")
	private List<Panier> panier;

	@Version
	private int version;
	
	public Produit() {
	}

	public Produit(Boutique boutique, String libelle, double prix, String description) {
		super();
		this.boutique = boutique;
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boutique getBoutique() {
		return boutique;
	}

	public void setBoutique(Boutique boutique) {
		this.boutique = boutique;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", boutique=" + boutique + ", libelle=" + libelle + ", prix=" + prix
				+ ", description=" + description + ", img=" + img + ", panier=" + panier + ", version=" + version + "]";
	}

	

}
