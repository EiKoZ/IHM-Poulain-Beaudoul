package bdd.etudiant;

import java.util.ArrayList;
import java.util.List;

public class Classe {
	// | Attributs : |
	private String groupe;
	private List<Etudiant> listeEtudiant;

	// | Constructeurs : |
	public Classe(String groupe) {
		super();
		this.groupe = groupe;
		this.listeEtudiant = new ArrayList<Etudiant>();
	}

	// | Methodes : |
	public void addEtudiant(Etudiant e) {
		listeEtudiant.add(e);
	}

	public void removeEtudiant(Etudiant etudiant) {
		if (listeEtudiant.contains(etudiant)) {
			listeEtudiant.remove(etudiant);
		}
	}

	// | Getteurs : |
	public String getGroupe() {
		return groupe;
	}

	// | toString(): |
	@Override
	public String toString() {
		return "Classe [groupe=" + groupe + ", listeEtudiant=" + listeEtudiant
				+ "]";
	}
}
