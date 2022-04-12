package sopraprojet.harrypotter.boutique;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;

@Entity
@Table(name = "livraison")
public class Livraison {

    public Livraison() {

    }
	@JsonView(JsonViews.Common.class)
    @Column(name = "id_livraison")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@JsonView(JsonViews.Common.class)
	private String modeLivraion;

	@JsonView(JsonViews.Common.class)
	private double prix;

 
	@JsonView(JsonViews.Common.class)
	private String description;
	
	@ManyToMany(mappedBy="modeLivraison")	
	private List<Boutique> boutiques;
	
	public Livraison(String modeLivraion, double prix, String description) {
		super();
		this.modeLivraion = modeLivraion;
		this.prix = prix;
		this.description = description;
	}
}
