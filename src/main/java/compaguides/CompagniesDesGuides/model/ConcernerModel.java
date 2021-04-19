package compaguides.CompagniesDesGuides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="concerner") //Indique la table de la BDD correspondant au modèle
public class ConcernerModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Sommets", nullable=false)
	int id;
	
	@Column(name="code_Randonnees")
	String code_randonnees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode_randonnees() {
		return code_randonnees;
	}

	public void setCode_randonnees(String code_randonnees) {
		this.code_randonnees = code_randonnees;
	}

	@Override
	public String toString() {
		return "ConcernerModel [id=" + id + ", code_randonnees=" + code_randonnees + "]";
	}
	

}

