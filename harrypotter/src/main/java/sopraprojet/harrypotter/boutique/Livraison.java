package sopraprojet.harrypotter.boutique;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Livraison {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_livraison")
	private Integer id;
	
	private String modeLivraion;
	
	
	private double prix;
	
	private String description;
	
	@ManyToMany(mappedBy="modeLivraison")	
	private List<Boutique> boutiques;

	public Livraison(String modeLivraion, double prix) {
		super();
		this.modeLivraion = modeLivraion;
		this.prix = prix;
	}
	
	public Livraison(String modeLivraion, double prix, String description) {
		super();
		this.modeLivraion = modeLivraion;
		this.prix = prix;
		this.description = description;
	}
	
	public String getModeLivraion() {
		return modeLivraion;
	}

	public void setModeLivraion(String modeLivraion) {
		this.modeLivraion = modeLivraion;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Boutique> getBoutiques() {
		return boutiques;
	}

	public void setBoutiques(List<Boutique> boutiques) {
		this.boutiques = boutiques;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
