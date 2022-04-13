/*
 * package sopraprojet.harrypotter.boutique;
 * 
 * import java.time.LocalDate; import java.time.LocalDateTime;
 * 
 * import javax.persistence.Column; import javax.persistence.Entity; import
 * javax.persistence.GeneratedValue; import javax.persistence.GenerationType;
 * import javax.persistence.Id; import javax.persistence.JoinColumn; import
 * javax.persistence.ManyToOne; import javax.persistence.Table; import
 * javax.persistence.Version;
 * 
 * import com.fasterxml.jackson.annotation.JsonView;
 * 
 * import sopraprojet.harrypotter.Json.JsonViews; import
 * sopraprojet.harrypotter.compte.Compte;
 * 
 * 
 * public class Panier {
 * 
 * //@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
 * //@JsonView(JsonViews.Common.class) protected Integer id;
 * 
 * //@JsonView(JsonViews.Common.class) //@Column(name = "quantite") private int
 * quantite;
 * 
 * //@JsonView(JsonViews.Common.class) //@ManyToOne //@JoinColumn(name =
 * "compte_id") private Compte compte;
 * 
 * //@JsonView(JsonViews.Common.class) //si achat est true, ce produit est
 * acheté, sinon c'est qu'il est en attente dans le panier private boolean achat
 * = false;
 * 
 * //@ManyToOne //@JoinColumn(name = "article_id")
 * //@JsonView(JsonViews.Common.class) private Produit articles;
 * 
 * //@Column(name="date_achat") private LocalDateTime dateAchat;
 * 
 * //@JsonView(JsonViews.Common.class) //@Version private int version;
 * 
 * public Panier() { }
 * 
 * public Panier(int quantite, Compte compte, boolean achat, Produit articles,
 * LocalDateTime dateAchat) { super(); this.quantite = quantite; this.compte =
 * compte; this.achat = achat; this.articles = articles; this.dateAchat =
 * dateAchat; }
 * 
 * public int getQuantite() { return quantite; }
 * 
 * public void setQuantite(int quantite) { this.quantite = quantite; }
 * 
 * public Produit getArticles() { return articles; }
 * 
 * public void setArticles(Produit article) { this.articles = article; }
 * 
 * public Integer getId() { return id; }
 * 
 * public void setId(Integer id) { this.id = id; }
 * 
 * public Compte getCompte() { return compte; }
 * 
 * public void setCompte(Compte compte) { this.compte = compte; }
 * 
 * public int getVersion() { return version; }
 * 
 * public void setVersion(int version) { this.version = version; }
 * 
 * public boolean isAchat() { return achat; }
 * 
 * public void setAchat(boolean achat) { this.achat = achat; }
 * 
 * 
 * 
 * public LocalDateTime getDateAchat() { return dateAchat; }
 * 
 * 
 * 
 * public void setDateAchat(LocalDateTime dateAchat) { this.dateAchat =
 * dateAchat; }
 * 
 * 
 * 
 * @Override public String toString() { return "Panier [id=" + id +
 * ", quantite=" + quantite + ", achat=" + achat + ", version=" + version + "]";
 * }
 * 
 * 
 * 
 * 
 * }
 */