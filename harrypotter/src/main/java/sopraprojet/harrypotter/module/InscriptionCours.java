package sopraprojet.harrypotter.module;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;
import sopraprojet.harrypotter.compte.Eleve;
import sopraprojet.harrypotter.compte.Prof;

@Entity
@Table(name = "Inscription_cours")
public class InscriptionCours {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_inscription")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cours_fk")
	private Cours cours;
	
	@ManyToOne
	@JoinColumn(name="eleve_fk")
	private Eleve eleve;

	@Version
	private int version;
	
	public InscriptionCours(Integer id, Cours cours, Eleve eleve) {
		this.id = id;
		this.cours = cours;
		this.eleve = eleve;
	}

	public InscriptionCours(Cours cours, Eleve eleve) {
		this.cours = cours;
		this.eleve = eleve;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	
	
}
