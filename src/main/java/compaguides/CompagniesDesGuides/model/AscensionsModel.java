package compaguides.CompagniesDesGuides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="ascension") //Indique la table de la BDD correspondant au modèle
public class AscensionsModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Sommets", nullable=false)
	int id;
	
	@Column(name="code_Abris")
	int code_abris;
	
	@Column(name="difficulte_Ascension")
	String difficulte;
	
	@Column(name="duree_Ascension")
	int duree;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCode_abris() {
		return code_abris;
	}

	public void setCode_abris(int code_abris) {
		this.code_abris = code_abris;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "AscensionsModel [id=" + id + ", code_abris=" + code_abris + ", difficulte=" + difficulte + ", duree="
				+ duree + "]";
	}
	

}

