package projet.cdg.compagnieDesGuides.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity //Indique Ã  Hibernate que cette correspondra Ã  une table dans la base de donnÃ©es
@Table(name="randonnees") //Indique la table de la BDD correspondant au modÃ¨le
public class RandonneesModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Randonnees", nullable=false)
	int id;
	
	@Column(name="nbPersonnes_Randonnees")
	int nombres_personnes;
	
	@Column(name="dateDebut_Randonnees")
	Date date_debut;
	
	@Column(name="dateFin_Randonnees")
	Date date_fin;
	
	@Column(name="code_Guides")
	int guide;
	
	@OneToMany(mappedBy="randonnees")
	Set<ReserverModel> reserver;
	
	@OneToMany(mappedBy="randonnees")
	Set<ConcernerModel> concerner;

	public int getGuide() {
		return guide;
	}

	public void setGuide(int guide) {
		this.guide = guide;
	}

	public Set<ReserverModel> getReserver() {
		return reserver;
	}

	public void setReserver(Set<ReserverModel> reserver) {
		this.reserver = reserver;
	}

	public Set<ConcernerModel> getConcerner() {
		return concerner;
	}

	public void setConcerner(Set<ConcernerModel> concerner) {
		this.concerner = concerner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombres_personnes() {
		return nombres_personnes;
	}

	public void setNombres_personnes(int nombres_personnes) {
		this.nombres_personnes = nombres_personnes;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public int get_guide() {
		return guide;
	}
	
	public void set_guide(int guide) {
		this.guide = guide;
	}

	@Override
	public String toString() {
		return "RandonneesModel [id=" + id + ", nombres_personnes=" + nombres_personnes + ", date_debut=" + date_debut
				+ ", date_fin=" + date_fin  + "]";
	}

	
	

}
