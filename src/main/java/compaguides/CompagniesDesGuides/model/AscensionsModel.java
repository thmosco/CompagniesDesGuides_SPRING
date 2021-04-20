package compaguides.CompagniesDesGuides.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="ascension") //Indique la table de la BDD correspondant au modèle
public class AscensionsModel {
	
	
	@EmbeddedId
	AscensionKey id;
	
	@ManyToOne
	@MapsId("code_sommet")
	@JoinColumn(name="code_Sommets")
	SommetsModel sommets;
	
	@ManyToOne
	@MapsId("code_abris")
	@JoinColumn(name="code_Abris")
	AbrisModel abris;
	
	@Column(name="difficulte_Ascension")
	String difficulte;
	
	@Column(name="duree_Ascension")
	int duree;

	public AscensionKey getId() {
		return id;
	}

	public void setId(AscensionKey id) {
		this.id = id;
	}

	public SommetsModel getSommets() {
		return sommets;
	}

	public void setSommet(SommetsModel sommets) {
		this.sommets = sommets;
	}

	public AbrisModel getAbris() {
		return abris;
	}

	public void setAbris(AbrisModel abris) {
		this.abris = abris;
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

	public void setSommets(SommetsModel sommets) {
		this.sommets = sommets;
	}

	@Override
	public String toString() {
		return "AscensionsModel [id=" + id + ", sommet=" + sommets + ", abris=" + abris + ", difficulte=" + difficulte
				+ ", duree=" + duree + "]";
	}

	
	

}

