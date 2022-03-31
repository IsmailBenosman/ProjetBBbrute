package event;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import compte.Eleve;

@Entity
@DiscriminatorValue("evenements")
@Table(name = "evenements")
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_evenement")
	private Integer id;
	
	@NotEmpty(message="Champ obligatoire")
	@Column(name="evenement")
	private String nomEven;
	
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotEmpty(message="Champ obligatoire")
	private LocalDate date;
	
	@NotEmpty(message="Champ obligatoire")
	private LocalTime heure;
	
	@ManyToMany
  	@JoinTable(
			name="participant_event",
			joinColumns = @JoinColumn(name="participant"),
			inverseJoinColumns = @JoinColumn(name="event")
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