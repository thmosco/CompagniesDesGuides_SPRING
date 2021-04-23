package projet.cdg.compagnieDesGuides.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import projet.cdg.compagnieDesGuides.keys.ConcernerKey;

@Entity //Indique Ã  Hibernate que cette correspondra Ã  une table dans la base de donnÃ©es
@Table(name="concerner") //Indique la table de la BDD correspondant au modÃ¨le
public class ConcernerModel {
	
	
	@EmbeddedId
	ConcernerKey id;
	
	@ManyToOne
	@MapsId("codesommets")
	@JoinColumn(name="code_Sommets",nullable=false)
	SommetsModel sommets;
	
	@ManyToOne
	@MapsId("coderandonnees")
	@JoinColumn(name="code_Randonnees",nullable=false)
	RandonneesModel randonnees;
	
	@Column(name="date_Concerner")
	String date_concerner;

	public RandonneesModel getRandonnees() {
		return randonnees;
	}

	public void setRandonnees(RandonneesModel randonnees) {
		this.randonnees = randonnees;
	}

	public SommetsModel getSommets() {
		return sommets;
	}

	public void setSommets(SommetsModel sommets) {
		this.sommets = sommets;
	}

	public String getDate_concerner() {
		return date_concerner;
	}

	public void setDate_concerner(String date_concerner) {
		this.date_concerner = date_concerner;
	}

	public ConcernerKey getId() {
		return id;
	}

	public void setId(ConcernerKey id) {
		this.id = id;
	}
	
}
