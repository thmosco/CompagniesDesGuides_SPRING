package compaguides.CompagniesDesGuides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="reserver") //Indique la table de la BDD correspondant au modèle
public class ReserverModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Abris", nullable=false)
	int id;
	
	@Column(name="code_Randonnees")
	int nombres_personnes;
	
	@Column(name="date_Reserver")
	String date_debut;
	
	@Column(name="statut_Reserver")
	String date_fin;

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

	public String getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}

	public String getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}

	@Override
	public String toString() {
		return "ReserverModel [id=" + id + ", nombres_personnes=" + nombres_personnes + ", date_debut=" + date_debut
				+ ", date_fin=" + date_fin + "]";
	}


	
	

}

