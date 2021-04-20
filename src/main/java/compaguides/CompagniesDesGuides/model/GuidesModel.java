package compaguides.CompagniesDesGuides.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Indique à Hibernate que cette correspondra à une table dans la base de données
@Table(name="guides") //Indique la table de la BDD correspondant au modèle
public class GuidesModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="code_Guides", nullable=false)
	int id;
	
	@Column(name="nom_Guides")
	String nom;
	
	@Column(name="prenom_Guides")
	String prenom;
	
	@Column(name="email_Guides")
	String email;
	
	@Column(name="motdepasse_Guides")
	String motdepasse;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	@Override
	public String toString() {
		return "GuidesModel [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motdepasse="
				+ motdepasse + "]";
	}
	
	

}

