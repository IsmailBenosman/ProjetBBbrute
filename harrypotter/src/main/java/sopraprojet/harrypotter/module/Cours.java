package module;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import compte.Prof;


@Entity
@DiscriminatorValue("cours")
@Table(name="cours")
public class Cours {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String intitule;
		
		
		@ManyToOne
		@JoinColumn(name="professeur_fk")
		private Prof professeur;
		
		@OneToOne
		private Modules module;

		public Cours() {}

		public Cours(Integer id, String intitule, Prof professeur, Modules module) {
			super();
			this.id = id;
			this.intitule = intitule;
			this.professeur = professeur;
			this.module = module;
		}


		public Cours(String intitule) {
			super();
			this.intitule = intitule;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getIntitule() {
			return intitule;
		}


		public void setIntitule(String intitule) {
			this.intitule = intitule;
		}


		public Prof getProfesseur() {
			return professeur;
		}


		public void setProfesseur(Prof professeur) {
			this.professeur = professeur;
		}


		public Modules getModule() {
			return module;
		}

		public void setModule(Modules module) {
			this.module = module;
		}

		@Override
		public String toString() {
			return "Cours [id=" + id + ", intitule=" + intitule + ", professeur=" + professeur + ", module=" + module
					+ "]";
		}


	
		

		
		
}
