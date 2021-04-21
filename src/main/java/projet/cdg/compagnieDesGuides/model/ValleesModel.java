package projet.cdg.compagnieDesGuides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="vallees") //Indique la table de la BDD correspondant au modèle
public class ValleesModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Vallees", nullable=false)
	int id;
	
	@Column(name="nom_vallees")
	String nom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

@Override
	public String toString() {
		return "ValleesModel [id=" + id + ", nom=" + nom + "]";
	}

}

