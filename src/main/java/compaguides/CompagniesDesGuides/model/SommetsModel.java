package compaguides.CompagniesDesGuides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="sommets") //Indique la table de la BDD correspondant au modèle
public class SommetsModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Sommets", nullable=false)
	int id;
	
	@Column(name="nom_Sommets")
	String nom;
	
	@Column(name="altitude_Sommets")
	int altitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	@Override
	public String toString() {
		return "SommetsModel [id=" + id + ", nom=" + nom + ", altitude=" + altitude + "]";
	}
	



}

