package projet.cdg.compagnieDesGuides.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import projet.cdg.compagnieDesGuides.keys.ReserverKey;

@Entity //Indique Ã  Hibernate que cette correspondra Ã  une table dans la base de donnÃ©es
@Table(name="reserver") //Indique la table de la BDD correspondant au modÃ¨le
public class ReserverModel {
	@EmbeddedId
	ReserverKey id;
	
	@ManyToOne
	@MapsId("code_Randonnees")
	@JoinColumn(name="code_Randonnees")
	RandonneesModel randonnees;
	
	@ManyToOne
	@MapsId("code_Abris")
	@JoinColumn(name="code_Abris")
	AbrisModel abris;
	
	@Column(name="date_Reserver")
	Date date_Reserver;
	
	@Column(name="statut_Reserver")
	String statut_Reserver;

	public RandonneesModel getRandonnees() {
		return randonnees;
	}

	public void setRandonnees(RandonneesModel randonnees) {
		this.randonnees = randonnees;
	}

	public AbrisModel getAbris() {
		return abris;
	}

	public void setAbris(AbrisModel abris) {
		this.abris = abris;
	}

	public Date getDate_Reserver() {
		return date_Reserver;
	}

	public void setDate_Reserver(Date date_Reserver) {
		this.date_Reserver = date_Reserver;
	}

	public String getStatut_Reserver() {
		return statut_Reserver;
	}

	public void setStatut_Reserver(String statut_Reserver) {
		this.statut_Reserver = statut_Reserver;
	}

	public ReserverKey getId() {
		return id;
	}

	public void setId(ReserverKey id) {
		this.id = id;
	}
	
	
}
