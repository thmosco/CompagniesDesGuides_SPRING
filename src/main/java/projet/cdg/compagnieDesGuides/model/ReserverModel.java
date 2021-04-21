package projet.cdg.compagnieDesGuides.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import projet.cdg.compagnieDesGuides.keys.ReserverKey;


public class ReserverModel {
	@EmbeddedId
	ReserverKey id;
	
	@ManyToOne
	@MapsId("code_Randonnees")
	@JoinColumn(name="code_Randonnees")
	Set<RandonneesModel> randonnees;
	
	@ManyToOne
	@MapsId("code_Abris")
	@JoinColumn(name="code_Abris")
	Set<AbrisModel> abris;
	
	@Column(name="date_Reserver")
	Date date_Reserver;
	
	@Column(name="statut_Reserver")
	String statut_Reserver;

	public Set<RandonneesModel> getRandonnees() {
		return randonnees;
	}

	public void setRandonnees(Set<RandonneesModel> randonnees) {
		this.randonnees = randonnees;
	}

	public Set<AbrisModel> getAbris() {
		return abris;
	}

	public void setAbris(Set<AbrisModel> abris) {
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
