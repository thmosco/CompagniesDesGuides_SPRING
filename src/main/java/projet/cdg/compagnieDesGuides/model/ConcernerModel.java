package projet.cdg.compagnieDesGuides.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import projet.cdg.compagnieDesGuides.keys.ConcernerKey;

public class ConcernerModel {
	@EmbeddedId
	ConcernerKey id;
	
	@ManyToOne
	@MapsId("code_randonnees")
	@JoinColumn(name="code_randonnees")
	Set<RandonneesModel> randonnees;
	
	@ManyToOne
	@MapsId("code_sommet")
	@JoinColumn(name="code_Sommets")
	Set<SommetsModel> sommets;
	
	@Column(name="date_concerner")
	Date date_concerner;

	public Set<RandonneesModel> getRandonnees() {
		return randonnees;
	}

	public void setRandonnees(Set<RandonneesModel> randonnees) {
		this.randonnees = randonnees;
	}

	public Set<SommetsModel> getSommets() {
		return sommets;
	}

	public void setSommets(Set<SommetsModel> sommets) {
		this.sommets = sommets;
	}

	public Date getDate_concerner() {
		return date_concerner;
	}

	public void setDate_concerner(Date date_concerner) {
		this.date_concerner = date_concerner;
	}

	public ConcernerKey getId() {
		return id;
	}

	public void setId(ConcernerKey id) {
		this.id = id;
	}
	
}
