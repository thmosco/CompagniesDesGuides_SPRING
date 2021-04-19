package compaguides.CompagniesDesGuides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="abris") //Indique la table de la BDD correspondant au modèle
public class AbrisModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Abris", nullable=false)
	int id;
	
	@Column(name="nom_Abris")
	String nom_abris;
	
	@Column(name="type_Abris")
	String type_abris;
	
	@Column(name="altitude_Abris")
	int altitude;
	
	@Column(name="prixNuit_Abris")
	float prix_nuit;

	@Column(name="prixRepas_Abris")
	float prix_repas;
	
	@Column(name="telGardien_Abris")
	int tel_gardien;
	
	@Column(name="code_Vallees")
	int code_vallee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_abris() {
		return nom_abris;
	}

	public void setNom_abris(String nom_abris) {
		this.nom_abris = nom_abris;
	}

	public String getType_abris() {
		return type_abris;
	}

	public void setType_abris(String type_abris) {
		this.type_abris = type_abris;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public float getPrix_nuit() {
		return prix_nuit;
	}

	public void setPrix_nuit(float prix_nuit) {
		this.prix_nuit = prix_nuit;
	}

	public float getPrix_repas() {
		return prix_repas;
	}

	public void setPrix_repas(float prix_repas) {
		this.prix_repas = prix_repas;
	}

	public int getTel_gardien() {
		return tel_gardien;
	}

	public void setTel_gardien(int tel_gardien) {
		this.tel_gardien = tel_gardien;
	}

	public int getCode_vallee() {
		return code_vallee;
	}

	public void setCode_vallee(int code_vallee) {
		this.code_vallee = code_vallee;
	}

	@Override
	public String toString() {
		return "AbrisModel [id=" + id + ", nom_abris=" + nom_abris + ", type_abris=" + type_abris + ", altitude="
				+ altitude + ", prix_nuit=" + prix_nuit + ", prix_repas=" + prix_repas + ", tel_gardien=" + tel_gardien
				+ ", code_vallee=" + code_vallee + "]";
	}
	
	

}

