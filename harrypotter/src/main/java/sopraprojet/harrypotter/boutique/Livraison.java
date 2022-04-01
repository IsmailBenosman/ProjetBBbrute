package sopraprojet.harrypotter.boutique;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "livraison")
public class Livraison {

    public Livraison() {

    }

    @Column(name = "id_livraison")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
	private String modeLivraion;

    @NotNull
	private double prix;

    @NotNull
    @NotEmpty
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
