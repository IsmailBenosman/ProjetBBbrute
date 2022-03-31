package sopraprojet.harrypotter.maison;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="maison")
public class Maison {

public Maison() {
	}
public Maison(Integer id, String nom, int score) {
		this.id = id;
		this.nom = nom;
		this.score = score;
	}
@Id
protected Integer id;
protected String nom;
protected  int score;
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
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
} 


}
