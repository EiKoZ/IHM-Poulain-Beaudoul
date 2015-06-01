package bdd.cours;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendrier {
	// | Attributs : |
	private Jour[][][] calendrier;
	private int anneeCourante;

	// | Constructeurs : |
	public Calendrier(int nbAnnee, int anneeCourante) {
		calendrier = new Jour[nbAnnee][12][31];
		this.anneeCourante = anneeCourante;
	}

	// | Methode : |
	public void addJour(Jour jour) {
		if (jour.getJour().get(Calendar.YEAR) >= anneeCourante
				&& (jour.getJour().get(Calendar.YEAR) - anneeCourante) < calendrier.length) {
			calendrier[jour.getJour().get(Calendar.YEAR) - anneeCourante][jour
					.getJour().get(Calendar.MONTH)][jour.getJour().get(
					Calendar.DAY_OF_MONTH)] = jour;
			trierCalendrier();
		}
	}

	public void trierCalendrier() {

	}

	// | Getteurs : |
	public Jour[][][] getCalendrier() {
		return calendrier;
	}

	public Jour[][] getAnnee(int annee) {
		if (annee >= anneeCourante
				&& (annee - anneeCourante) < calendrier.length) {
			return calendrier[annee - anneeCourante];
		}

		return null;
	}

	public Jour[] getMois(int annee, int mois) {
		if (annee >= anneeCourante
				&& (annee - anneeCourante) < calendrier.length) {
			if (mois >= 0 && mois < 12) {
				return calendrier[annee - anneeCourante][mois];
			}
		}

		return null;
	}

	public Jour getJour(int annee, int mois, int jour) {
		if (annee >= anneeCourante
				&& (annee - anneeCourante) < calendrier.length) {
			if (mois >= 0 && mois < 12) {
				if (jour >= 0 && jour < 31) {
					return calendrier[annee - anneeCourante][mois][jour];
				}
			}
		}

		return null;
	}

	@Override
	public String toString() {
		String inter = "[";

		for (int i = 0; i < calendrier.length; i++) {
			inter += anneeCourante + i + " [";
			for (int j = 0; j < calendrier[i].length; j++) {
				inter += (j + 1) + " [";
				for (int j2 = 0; j2 < calendrier[i][j].length; j2++) {
					if (calendrier[i][j][j2] != null) {
						inter += j2 + " [" + calendrier[i][j][j2].toString()
								+ "],\n";
					}
				}
				inter += "]\n";
			}
			inter += "]\n";
		}

		return "Calendrier [calendrier=\n" + inter + ", anneeCourante="
				+ anneeCourante + "]";
	}

}
