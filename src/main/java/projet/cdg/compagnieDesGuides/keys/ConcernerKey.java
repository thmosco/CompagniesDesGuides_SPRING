package projet.cdg.compagnieDesGuides.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConcernerKey implements Serializable {

	@Column(name = "code_Sommets")
    int codesommets;

	@Column(name = "code_Randonnees")
    int coderandonnees;

	public int getCodesommets() {
		return codesommets;
	}

	public void setCodesommets(int codesommets) {
		this.codesommets = codesommets;
	}

	public int getCoderandonnees() {
		return coderandonnees;
	}

	public void setCoderandonnees(int coderandonnees) {
		this.coderandonnees = coderandonnees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coderandonnees;
		result = prime * result + codesommets;
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
		if (coderandonnees != other.coderandonnees)
			return false;
		if (codesommets != other.codesommets)
			return false;
		return true;
	}

	
}
