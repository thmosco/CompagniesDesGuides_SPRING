package projet.cdg.compagnieDesGuides.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReserverKey implements Serializable {
	@Column(name = "codeabris")
    int codeabris;

	@Column(name = "coderandonnees")
    int coderandonnees;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codeabris;
		result = prime * result + coderandonnees;
		return result;
	}

	public int getCodeabris() {
		return codeabris;
	}

	public void setCodeabris(int codeabris) {
		this.codeabris = codeabris;
	}

	public int getCoderandonnees() {
		return coderandonnees;
	}

	public void setCoderandonnees(int coderandonnees) {
		this.coderandonnees = coderandonnees;
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
		if (codeabris != other.codeabris)
			return false;
		if (coderandonnees != other.coderandonnees)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReserverKey [codeabris=" + codeabris + ", coderandonnees=" + coderandonnees + "]";
	}


	
}
