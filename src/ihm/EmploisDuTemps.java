package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EmploisDuTemps {

	int nbcour = 100;
	JList list;

	public EmploisDuTemps() {

		JFrame fen = new JFrame("Ecran mobile");
		fen.setPreferredSize(new Dimension(320, 480));
		fen.setLayout(null);
		fen.getContentPane().setBackground(Color.DARK_GRAY);
		JPanel panhaut = new JPanel();
		JPanel pancentre = new JPanel();
		JPanel panbas = new JPanel();

		/* panneau haut */

		// panhaut.setPreferredSize(new Dimension(300,75));
		panhaut.setBackground(Color.gray);
		panhaut.setLayout(null);
		panhaut.setBounds(4, 5, 296, 75);
		panhaut.repaint();
		/* bouton logout */
		JPanel panhautbtn = new JPanel();
		panhautbtn.setBounds(240, 25, 50, 25);
		panhautbtn.repaint();
		panhautbtn.setBackground(new Color(150, 150, 150));
		panhautbtn.setLayout(new BorderLayout());
		JLabel ecritureBtn = new JLabel("Logout", JLabel.CENTER);
		ecritureBtn.setFont(new Font("Cantarell", Font.BOLD, 12));
		panhautbtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				fen.dispose();
				new Login();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				panhautbtn.setBackground(Color.lightGray);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panhautbtn.add(ecritureBtn, BorderLayout.CENTER);

		/* JLabel pour ecrire "NOM" au dessus du JtextArea */

		JLabel textNom = new JLabel("Nom", JLabel.CENTER);
		textNom.setFont(new Font("Cantarell", Font.BOLD, 12));
		textNom.setBounds(87, 8, 50, 15);
		textNom.repaint();

		/* zone de texte pour le nom */
		JTextArea zonetextnom = new JTextArea("mettre une variable ici", 1, 1);
		zonetextnom.setEditable(false);
		zonetextnom.setBounds(100, 25, 125, 25);
		zonetextnom.repaint();

		/* zone photo */
		Image image = null;
		JLabel viewer = null;
		try {
			image = ImageIO.read(new File("./Prof.jpg"));
			viewer = new JLabel(new ImageIcon(image));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		viewer.setBounds(15, 7, 58, 60);
		viewer.repaint();

		/* ajout au panneau haut */
		panhaut.add(viewer);
		panhaut.add(textNom);
		panhaut.add(zonetextnom);
		panhaut.add(panhautbtn);

		ecritureBtn.setVisible(true);
		panhautbtn.setVisible(true);
		panhaut.setVisible(true);
		/* panneau centre */

		// pancentre.setPreferredSize(new Dimension(300,75));
		pancentre.setBackground(Color.LIGHT_GRAY);
		pancentre.setLayout(null);
		pancentre.setBounds(4, 83, 296, 75);
		pancentre.repaint();
		pancentre.setVisible(true);

		/* le jlabel avec l'heure */

		JLabel ept = new JLabel("Emploi du temps  |   "
				+ Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + "h");
		ept.setBounds(100, 10, 150, 25);
		ept.repaint();

		/* comboboxgauche */

		JComboBox<String> combogauche = new JComboBox<String>();
		combogauche.setBounds(100, 30, 60, 25);
		combogauche.repaint();

		/* comboboxdroit */

		JComboBox<String> combodroit = new JComboBox<String>();
		combodroit.setBounds(170, 30, 60, 25);
		combodroit.repaint();

		/* ajout panneau centre */
		pancentre.add(combodroit);
		pancentre.add(combogauche);
		pancentre.add(ept);

		/* panneau bas */

		// panbas.setPreferredSize(new Dimension(15,480));
		panbas.setBackground(Color.LIGHT_GRAY);
		panbas.setBounds(4, 161, 296, 275);
		panbas.repaint();
		GridLayout grid = new GridLayout(1, 2);

		panbas.setLayout(grid);

		/* declaration des panel scrollable */
		int mois = 1;
		int jour = 1;
		int jourAnneScolaire = 3285;
		String[] cases = new String[jourAnneScolaire];
		list = new JList(cases);

		list.setVisibleRowCount(9);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		int heure = 8;
		for (int i = 0; i < jourAnneScolaire  ; i++) {
			cases[i]="heure : "+heure;
			
			if(heure > 16){
				
				heure = 7;
				jour++;
			}
			if(heure == 8){
				cases[i]+=" jours : "+jour+"  mois :"+mois;
			}
				
			if(jour>31){
				mois++;
				jour=1;
			}
			heure++;	
			
		}

		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				new Login();
				fen.dispose();
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

			}
		});

		JScrollPane scroller = new JScrollPane(list);
		Border b = BorderFactory.createTitledBorder("Liste");
		scroller.setBorder(b);

		panbas.add(scroller);

		panbas.setVisible(true);

		/* ajout a la fenetre */
		fen.getContentPane().add(panhaut);
		fen.getContentPane().add(pancentre);
		fen.getContentPane().add(panbas);
		// fen.setResizable(false);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);

	}

	public static void main(String[] args) {

		new EmploisDuTemps();

	}
}
