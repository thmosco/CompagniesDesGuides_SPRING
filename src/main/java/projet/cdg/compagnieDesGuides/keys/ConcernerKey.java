package projet.cdg.compagnieDesGuides.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConcernerKey implements Serializable {

	@Column(name = "code_Sommets")
    int code_sommets;

	@Column(name = "code_Randonnees")
    int code_randonnees;

	public int getCode_sommet() {
		return code_sommets;
	}

	public void setCode_sommet(int code_sommet) {
		this.code_sommets = code_sommet;
	}

	public int getCode_Randonnees() {
		return code_randonnees;
	}

	public void setCode_Randonnees(int code_Randonnees) {
		this.code_randonnees = code_Randonnees;
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code_randonnees;
		result = prime * result + code_sommets;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConcernerKey other = (ConcernerKey) obj;
		if (code_randonnees != other.code_randonnees)
			return false;
		if (code_sommets != other.code_sommets)
			return false;
		return true;
	}
	
}
