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
	@MapsId("coderandonnees")
	@JoinColumn(name="code_Randonnees")
	RandonneesModel randonnees;
	
	@ManyToOne
	@MapsId("codeabris")
	@JoinColumn(name="code_Abris")
	AbrisModel abris;
	
	@Column(name="date_Reserver")
	String date_Reserver;
	
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

	public String getDate_Reserver() {
		return date_Reserver;
	}

	public void setDate_Reserver(String date_Reserver) {
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

	@Override
	public String toString() {
		return "ReserverModel [id=" + id + ", randonnees=" + randonnees + ", abris=" + abris + ", date_Reserver="
				+ date_Reserver + ", statut_Reserver=" + statut_Reserver + "]";
	}
	
	
}
