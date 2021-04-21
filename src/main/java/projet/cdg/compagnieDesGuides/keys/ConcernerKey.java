package projet.cdg.compagnieDesGuides.keys;

import javax.persistence.Column;

public class ConcernerKey {

	@Column(name = "code_Sommets")
    int code_Sommets;

	@Column(name = "code_Randonnees")
    int code_Randonnees;

	public int getCode_sommet() {
		return code_Sommets;
	}

	public void setCode_sommet(int code_sommet) {
		this.code_Sommets = code_sommet;
	}

	public int getCode_Randonnees() {
		return code_Randonnees;
	}

	public void setCode_Randonnees(int code_Randonnees) {
		this.code_Randonnees = code_Randonnees;
	}
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code_Randonnees;
		result = prime * result + code_Sommets;
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
		if (code_Randonnees != other.code_Randonnees)
			return false;
		if (code_Sommets != other.code_Sommets)
			return false;
		return true;
	}
	
}
