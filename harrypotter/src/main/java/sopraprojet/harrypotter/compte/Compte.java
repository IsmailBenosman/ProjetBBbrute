package sopraprojet.harrypotter.compte;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Past;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.ecole.Maison;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Eleve.class, name = "eleve"), @Type(value = Admin.class, name = "admin"),
		@Type(value = Prof.class, name = "prof") })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte", columnDefinition = "ENUM('eleve','prof','admin')")
@Table(name = "compte")
public abstract class Compte implements UserDetails {
	/*
	 * @OneToMany(mappedBy = "compte") private List<Panier> panier;
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_compte")
	@JsonView(JsonViews.Common.class)
	protected Integer id;

	@JsonView(JsonViews.Common.class)
	protected String nom;

	@JsonView(JsonViews.Common.class)
	protected String prenom;

	@JsonView(JsonViews.Common.class)
	@Column(name = "login")
	protected String login;

	@JsonView(JsonViews.Common.class)
	@Column(name = "password")
	protected String password;

	@Past
	@JsonView(JsonViews.Common.class)
	protected LocalDate naissance;

	@JsonView(JsonViews.Common.class)
	protected double solde;
	
	@JsonView(JsonViews.Common.class)
	protected String img;

	@JsonView(JsonViews.Common.class)
	@ManyToOne
	private Maison maison;


	@Version
	private int version;

	public Compte() {
	}

	public Compte(Integer id, String nom, String prenom, String login, String password, LocalDate naissance,
			double solde, Maison maison) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.naissance = naissance;
		this.solde = solde;
		this.maison = maison;
	}

	public Compte(String nom, String prenom, String login, String password, LocalDate naissance, double solde,
			Maison maison) {
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.naissance = naissance;
		this.solde = solde;
		this.maison = maison;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	/*
	 * public List<Panier> getPanier() { return panier; }
	 * 
	 * public void setPanier(List<Panier> panier) { this.panier = panier; }
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		GrantedAuthority authority = null;
		if (getClass().getSimpleName().equals("Eleve")) {
			authority = new SimpleGrantedAuthority("ROLE_ELEVE");
		} else if (getClass().getSimpleName().equals("Prof")) {
			authority = new SimpleGrantedAuthority("ROLE_PROF");
		} else if (getClass().getSimpleName().equals("Admin")) {
			authority = new SimpleGrantedAuthority("ROLE_ADMIN");
		}
		return Arrays.asList(authority);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


}
