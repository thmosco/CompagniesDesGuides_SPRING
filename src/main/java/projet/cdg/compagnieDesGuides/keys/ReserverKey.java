package projet.cdg.compagnieDesGuides.keys;

import javax.persistence.Column;

public class ReserverKey {
	@Column(name = "code_Abris")
    int code_Abris;

	@Column(name = "code_Randonnees")
    int code_Randonnees;

	public int getCode_Abris() {
		return code_Abris;
	}

	public void setCode_Abris(int code_Abris) {
		this.code_Abris = code_Abris;
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
		result = prime * result + code_Abris;
		result = prime * result + code_Randonnees;
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
		ReserverKey other = (ReserverKey) obj;
		if (code_Abris != other.code_Abris)
			return false;
		if (code_Randonnees != other.code_Randonnees)
			return false;
		return true;
	}
	
}
