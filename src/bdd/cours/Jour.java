package bdd.cours;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import bdd.etudiant.Classe;

public class Jour {
	// | Attributs : |
	private GregorianCalendar jour;
	private List<Cours> emploiDuTemps;
	private boolean coursPassee;

	// | Constructeurs : |
	public Jour(GregorianCalendar jour) {
		super();
		this.jour = jour;
		this.emploiDuTemps = new ArrayList<Cours>();
		coursPassee = false;
	}

	// | Methodes : |
	public void creerUnCours(String nomCours, GregorianCalendar heureDebut,
			GregorianCalendar heureFin, Classe classe) {
		if ((heureFin.get(Calendar.HOUR_OF_DAY) - heureDebut
				.get(Calendar.HOUR_OF_DAY)) > 1) {
			GregorianCalendar newHourFin = new GregorianCalendar(
					heureFin.get(Calendar.YEAR), heureFin.get(Calendar.MONTH),
					heureFin.get(Calendar.DAY_OF_MONTH),
					heureFin.get(Calendar.HOUR_OF_DAY) - 1,
					heureFin.get(Calendar.MINUTE));
			emploiDuTemps.add(new Cours(nomCours, heureDebut, newHourFin,
					classe));
			emploiDuTemps
					.add(new Cours(nomCours, newHourFin, heureFin, classe));
		} else {
			emploiDuTemps
					.add(new Cours(nomCours, heureDebut, heureFin, classe));
		}
	}

	public void ajouterUnCours(Cours cours) {
		if ((cours.getHeureFin().get(Calendar.HOUR_OF_DAY) - cours
				.getHeureDebut().get(Calendar.HOUR_OF_DAY)) > 1) {
			GregorianCalendar newHourFin = new GregorianCalendar(cours
					.getHeureFin().get(Calendar.YEAR), cours.getHeureFin().get(
					Calendar.MONTH), cours.getHeureFin().get(
					Calendar.DAY_OF_MONTH), cours.getHeureFin().get(
					Calendar.HOUR_OF_DAY - 1), cours.getHeureFin().get(
					Calendar.MINUTE));
			emploiDuTemps.add(new Cours(cours.getCours(),
					cours.getHeureDebut(), newHourFin, cours.getClasse()));
			emploiDuTemps.add(new Cours(cours.getCours(), newHourFin, cours
					.getHeureFin(), cours.getClasse()));
		} else {
			emploiDuTemps.add(new Cours(cours.getCours(),
					cours.getHeureDebut(), cours.getHeureFin(), cours
							.getClasse()));
		}
	}

	// | Getteurs : |
	public GregorianCalendar getJour() {
		return jour;
	}

	public List<Cours> getEmploiDuTemps() {
		return emploiDuTemps;
	}

	public boolean isCoursPasse() {
		return coursPassee;
	}

	public void setCoursPasse(boolean coursPasse) {
		this.coursPassee = coursPasse;
	}

	@Override
	public String toString() {
		return "Jour [jour=" + jour.get(Calendar.YEAR) + "-"
				+ jour.get(Calendar.MONDAY) + "-"
				+ jour.get(Calendar.DAY_OF_MONTH) + ", emploiDuTemps="
				+ emploiDuTemps + ", coursPassee=" + coursPassee + "]";
	}

}
