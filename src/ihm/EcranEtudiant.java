package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import bdd.etudiant.Etudiant;

@SuppressWarnings("serial")
public class EcranEtudiant extends JFrame {
	// | Attributs : |
	private Etudiant e;

	// | Costructeurs : |
	public EcranEtudiant(Etudiant e) {
		// TODO Auto-generated constructor stub
		this.e = e;

		this.setTitle("Ecran Etudiant");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(320, 480));
		this.setResizable(false);
		this.setLayout(null);

		this.add(createHeader());
		this.add(createMain());
		this.add(createFooter());

		this.pack();
		this.setVisible(true);
	}

	public JPanel createHeader() {
		JPanel header = new JPanel();
		header.setBorder(BorderFactory.createBevelBorder(0));
		header.setBackground(Color.BLACK);
		header.setBounds(-2, -2, 320, 100);
		header.setLayout(null);

		JLabel header_photo = new JLabel("Photo");
		header_photo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		header_photo.setHorizontalAlignment(JLabel.CENTER);
		header_photo.setVerticalAlignment(JLabel.CENTER);
		header_photo.setBounds(10, 10, 70, 80);
		header_photo.setIcon(e.getPhoto());
		header.add(header_photo);

		JTextArea header_etudiantinfo = new JTextArea(e.getPrenom() + " "
				+ e.getNom());
		header_etudiantinfo.setBorder(BorderFactory
				.createLineBorder(Color.BLACK));
		header_etudiantinfo.setBounds(100, 10, 190, 80);
		header_etudiantinfo.setEditable(false);
		header.add(header_etudiantinfo);
		return header;
	}

	public JPanel createMain() {
		JPanel main = new JPanel();
		main.setBounds(0, 101, 320, 290);
		main.setLayout(null);

		JTextArea main_commentaire = new JTextArea(e.getCommentaire());
		main_commentaire.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		main_commentaire.setBounds(5, 5, 295, 200);
		main.add(main_commentaire);

		JCheckBox main_signalement = new JCheckBox(
				"Signaler l'étudiant à l'académie des Trouduc");
		main_signalement.setBounds(15, 205, 300, 20);

		if (e.getSignalee() == true) {
			main_signalement.setSelected(true);
		}

		main_signalement.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				e.setSignalee(true);
			}
		});
		main.add(main_signalement);

		JButton main_valider = new JButton("Valider");
		main_valider.setBounds(110, 235, 100, 30);
		main_valider.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				e.setCommentaire(main_commentaire.getText());
			}
		});
		main.add(main_valider);

		return main;
	}

	public JPanel createFooter() {
		JPanel footer = new JPanel();
		footer.setBorder(BorderFactory.createBevelBorder(0));
		footer.setBackground(Color.GRAY);
		footer.setBounds(-2, 402, 320, 50);
		footer.setLayout(null);

		JLabel footer_text = new JLabel("Absent : 20 minutes");
		footer_text.setBounds(55, 10, 200, 30);
		footer_text.setHorizontalAlignment(JLabel.CENTER);
		footer_text.setVerticalAlignment(JLabel.CENTER);
		footer.add(footer_text);

		return footer;
	}

	public static void main(String[] args) {
		Etudiant etudiant = new Etudiant("Paul-Henri", "Levis",
				"popol@gmail.com", 12, 15);
		etudiant.setCommentaire("Je suis un exemple de commeraire fait à l'éléve !");
		etudiant.setSignalee(true);

		// Opération pour redimensionner l'image
		ImageIcon icon = new ImageIcon("images/photo.png.png");
		Image img = icon.getImage();
		ImageIcon newIcon = new ImageIcon(img.getScaledInstance(70, 80,
				Image.SCALE_DEFAULT));

		etudiant.setPhoto(newIcon);

		new EcranEtudiant(etudiant);
	}
}
