/**
 * 
 */
package bdd.etudiant;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * @author LapinZinski
 *
 */
public class Etudiant {
	// | Attributs :
	private String nom;
	private String prenom;
	private String email;
	private double moyenneGenerale;
	private double moyenneCours;
	private String commentaire;
	private boolean signalee;
	private ImageIcon photo;

	// | Constructeurs : |
	public Etudiant(String nom, String prenom, String email,
			double moyenneGenerale, double moyenneCours) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.moyenneGenerale = moyenneGenerale;
		this.moyenneCours = moyenneCours;
		this.signalee = false;
	}

	// | Getteurs : |
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public double getMoyenneGenerale() {
		return moyenneGenerale;
	}

	public double getMoyenneCours() {
		return moyenneCours;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean getSignalee() {
		return signalee;
	}

	public void setSignalee(boolean signalee) {
		this.signalee = signalee;
	}

	public ImageIcon getPhoto() {
		return photo;
	}

	public void setPhoto(ImageIcon photo) {
		this.photo = photo;
	}

	// | toString() : |
	@Override
	public String toString() {
		return "Etudiant [nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", moyenneGenerale=" + moyenneGenerale
				+ ", moyenneCours=" + moyenneCours + "]";
	}

}
