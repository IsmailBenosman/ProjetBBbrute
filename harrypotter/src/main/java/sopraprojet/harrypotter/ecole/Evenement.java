package sopraprojet.harrypotter.ecole;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import sopraprojet.harrypotter.Json.JsonViews;
import sopraprojet.harrypotter.compte.Eleve;



@Entity
@DiscriminatorValue("evenements")
@Table(name = "evenements")
public class Evenement {
	
	@JsonView(JsonViews.Common.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evenement")
	private Integer id;
	@JsonView(JsonViews.Common.class)
	@NotEmpty(message="Champ obligatoire")
	@Column(name="evenement")
	private String nomEven;
	@JsonView(JsonViews.Common.class)
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	
	private LocalTime heure;
	
	@ManyToMany
  	@JoinTable(
			name="participant_event",
			joinColumns = @JoinColumn(name="event"),
			inverseJoinColumns = @JoinColumn(name="participant")
			)
	private List<Eleve> participants;
	
    @Version
	private int version;
	
	public Evenement() {}

	public Evenement(String nomEven, LocalDate date, LocalTime heure) {
		this.nomEven = nomEven;
		this.date = date;
		this.heure = heure;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEven() {
		return nomEven;
	}

	public void setNomEven(String nomEven) {
		this.nomEven = nomEven;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Eleve> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Eleve> participants) {
		this.participants = participants;
	}

	
	
}