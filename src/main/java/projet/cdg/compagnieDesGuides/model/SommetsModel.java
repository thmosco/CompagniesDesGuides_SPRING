package projet.cdg.compagnieDesGuides.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Indique Ã  Hibernate que cette correspondra Ã  une table dans la base de donnÃ©es
@Table(name="sommets") //Indique la table de la BDD correspondant au modÃ¨le
public class SommetsModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Sommets", nullable=false)
	int id;
	
	@Column(name="nom_Sommets")
	String nom;
	
	@Column(name="altitude_Sommets")
	int altitude;
	
	@OneToMany(mappedBy="sommets")
	Set<AscensionsModel> ascensions;

	@OneToMany(mappedBy="sommets")
	Set<ConcernerModel> concerner;
	
	public Set<ConcernerModel> getConcerner() {
		return concerner;
	}

	public void setConcerner(Set<ConcernerModel> concerner) {
		this.concerner = concerner;
	}

	public Set<AscensionsModel> getAscensions() {
		return ascensions;
	}

	public void setAscensions(Set<AscensionsModel> ascensions) {
		this.ascensions = ascensions;
	}

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

