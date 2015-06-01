import java.util.GregorianCalendar;

import bdd.cours.Calendrier;
import bdd.cours.Jour;
import bdd.etudiant.Classe;
import bdd.etudiant.Etudiant;

public class Essai {
	public static void main(String[] args) {
		Calendrier cal = new Calendrier(2, 2015);

		cal.addJour(new Jour(new GregorianCalendar(2015, 1, 1, 0, 00)));
		cal.addJour(new Jour(new GregorianCalendar(2016, 1, 1, 0, 00)));
		cal.addJour(new Jour(new GregorianCalendar(2015, 2, 12, 0, 00)));
		cal.addJour(new Jour(new GregorianCalendar(2016, 2, 12, 0, 00)));
		
		Classe b = new Classe("B");
		b.addEtudiant(new Etudiant("Paul", "François", "null", 12.00, 10.00));

		cal.getJour(2015, 1, 1).creerUnCours("IHM",
				new GregorianCalendar(2015, 1, 1, 12, 00),
				new GregorianCalendar(2015, 1, 1, 13, 00), b);

		cal.getJour(2015, 1, 1).creerUnCours("IHM",
				new GregorianCalendar(2015, 1, 1, 13, 00),
				new GregorianCalendar(2015, 1, 1, 15, 00), b);

		System.out.println(cal);
	}
}
