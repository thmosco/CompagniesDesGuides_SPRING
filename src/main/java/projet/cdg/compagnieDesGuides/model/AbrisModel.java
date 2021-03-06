package projet.cdg.compagnieDesGuides.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //Indique Ã  Hibernate que cette correspondra Ã  une table dans la base de donnÃ©es
@Table(name="abris") //Indique la table de la BDD correspondant au modÃ¨le
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
	Float prix_nuit;

	@Column(name="prixRepas_Abris")
	Float prix_repas;
	
	@Column(name="telGardien_Abris")
	Integer tel_gardien;

	@ManyToOne
	@JoinColumn(name="code_Vallees", nullable=false)
	ValleesModel vallee;

	@OneToMany(mappedBy="abris")
	Set<AscensionsModel> ascensions;
	
	@OneToMany(mappedBy="abris")
	Set<ReserverModel> reserver;
	
	public ValleesModel getVallee() {
		return vallee;
	}

	public Set<ReserverModel> getReserver() {
		return reserver;
	}

	public void setReserver(Set<ReserverModel> reserver) {
		this.reserver = reserver;
	}

	public void setVallee(ValleesModel vallee) {
		this.vallee = vallee;
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

	public Float getPrix_nuit() {
		return prix_nuit;
	}

	public void setPrix_nuit(Float prix_nuit) {
		this.prix_nuit = prix_nuit;
	}

	public Float getPrix_repas() {
		return prix_repas;
	}

	public void setPrix_repas(Float prix_repas) {
		this.prix_repas = prix_repas;
	}

	public Integer getTel_gardien() {
		return tel_gardien;
	}

	public void setTel_gardien(Integer tel_gardien) {
		this.tel_gardien = tel_gardien;
	}


	@Override
	public String toString() {
		return "AbrisModel [id=" + id + ", nom_abris=" + nom_abris + ", type_abris=" + type_abris + ", altitude="
				+ altitude + ", prix_nuit=" + prix_nuit + ", prix_repas=" + prix_repas + ", tel_gardien=" + tel_gardien
				+ ", code_vallee=" + vallee + "]";
	}
	
	

}

