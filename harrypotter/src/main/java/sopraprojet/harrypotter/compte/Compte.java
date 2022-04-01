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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import sopraprojet.harrypotter.boutique.Panier;
import sopraprojet.harrypotter.maison.Maison;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type_compte", columnDefinition = "ENUM('eleve','prof','admin')")
@Table(name = "compte")
public abstract class Compte implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_compte")
	protected Integer id;

	@NotEmpty(message = "Champ obligatoire")
	protected String nom;

	@NotEmpty(message = "Champ obligatoire")
	protected String prenom;

	@NotEmpty(message = "Champ obligatoire")
	@Column(name = "login", nullable = false, length = 200)
	protected String login;

	@NotEmpty(message = "Champ obligatoire")
	@Column(name = "password", nullable = false, length = 200)
	protected String password;

	@Past
	protected LocalDate naissance;

	protected double solde;
	protected String img;
	
	@ManyToOne
	private Maison maison;
	
	@OneToOne(mappedBy="compte")
	private Panier panier;

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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		GrantedAuthority authority = null;
		if (getClass().getSimpleName().equals("Eleve")) {
			authority = new SimpleGrantedAuthority("ROLE_ELEVE");
		} else if (getClass().getSimpleName().equals("Prof")) {
			authority = new SimpleGrantedAuthority("ROLE_PROF");
		} else if (getClass().getSimpleName().equals("Admin")) {
			authority = new SimpleGrantedAuthority("ROLE_Admin");
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
