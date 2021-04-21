package projet.cdg.compagnieDesGuides.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AscensionKey implements Serializable {
	
	@Column(name = "code_Sommets")
    int code_sommet;

    @Column(name = "code_Abris")
    int code_abris;

	

	public int getCode_sommet() {
		return code_sommet;
	}

	public void setCode_sommet(int code_sommet) {
		this.code_sommet = code_sommet;
	}

	public int getCode_abris() {
		return code_abris;
	}

	public void setCode_abris(int code_abris) {
		this.code_abris = code_abris;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code_abris;
		result = prime * result + code_sommet;
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
		AscensionKey other = (AscensionKey) obj;
		if (code_abris != other.code_abris)
			return false;
		if (code_sommet != other.code_sommet)
			return false;
		return true;
	}
}
