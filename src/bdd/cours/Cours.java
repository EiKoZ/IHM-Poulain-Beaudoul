package bdd.cours;

import java.util.Calendar;
import java.util.GregorianCalendar;

import bdd.etudiant.Classe;

public class Cours {
	// | Attributs : |
	private String cours;
	private GregorianCalendar heureDebut;
	private GregorianCalendar heureFin;
	private Classe classe;

	// | Constructeurs : |
	public Cours(String cours, GregorianCalendar heureDebut,
			GregorianCalendar heureFin, Classe classe) {
		super();
		this.cours = cours;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.classe = classe;
	}

	// | Getteurs : |
	public String getCours() {
		return cours;
	}

	public GregorianCalendar getHeureDebut() {
		return heureDebut;
	}

	public GregorianCalendar getHeureFin() {
		return heureFin;
	}

	public Classe getClasse() {
		return classe;
	}

	@Override
	public String toString() {
		return "Cours [cours=" + cours + ", heureDebut="
				+ heureDebut.get(Calendar.HOUR_OF_DAY) + ":"
				+ heureDebut.get(Calendar.MINUTE) + ", heureFin="
				+ heureFin.get(Calendar.HOUR_OF_DAY) + ":"
				+ heureFin.get(Calendar.MINUTE) + ", classe=" + classe + "]";
	}

}
