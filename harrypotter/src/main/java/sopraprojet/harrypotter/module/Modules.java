package module;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import compte.Eleve;

@Entity
@DiscriminatorValue("module")
@Table(name = "module")
public class Modules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int note;
	private String commentaire;


	@OneToOne(mappedBy="module")
	private Cours cours;
	@ManyToOne
	@JoinColumn(name="eleve_fk")
	private Eleve eleve;

	public Modules() {

	}	
	public Modules(Cours cours, int note, String commentaire) {
		super();
		this.cours = cours;
		this.note = note;
		this.commentaire = commentaire;
	}
	
	
	public Modules(int note, String commentaire, Cours cours) {
		super();
		this.note = note;
		this.commentaire = commentaire;
		this.cours = cours;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	@Override
	public String toString() {
		return "Modules [id=" + id + ", note=" + note + ", commentaire=" + commentaire + ", cours=" + cours + ", eleve="
				+ eleve + "]";
	}




}
