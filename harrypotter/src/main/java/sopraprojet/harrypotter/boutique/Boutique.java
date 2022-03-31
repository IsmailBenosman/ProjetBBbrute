package boutique;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;

import Json.JsonViews;

@Entity
@Component
@Table(name="boutiques")
public class Boutique {

	
	@JsonView(JsonViews.Common.class)
	@Enumerated(EnumType.STRING)
	private Categorie categorie;	

	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonView(JsonViews.Common.class)
	private String nom;
	
	@JsonView(JsonViews.Common.class)
	private String adresse;
	
	@OneToMany(mappedBy="boutique")
	private List<Produit> produits;

	@Version
	private int version;
	
	
	public Boutique() {}
	


	public Boutique(Categorie categorie, String nom, String adresse) {
		super();
		this.categorie = categorie;
		this.nom = nom;
		this.adresse = adresse;
	}


	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Produit> getProduit() {
		return produits;
	}
	public void setProduit(List<Produit> produits) {
		this.produits = produits;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	
}
