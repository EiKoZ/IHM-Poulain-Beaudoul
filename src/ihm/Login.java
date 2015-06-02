package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.sound.midi.ShortMessage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Login {
	public Login() {
		// TODO Auto-generated constructor stub
		JFrame fen = new JFrame("Ecran login");
		fen.setPreferredSize(new Dimension (320,480));
		fen.setLayout(null);
		fen.getContentPane().setBackground(new Color(191,49,115));
		JPanel panlogo = new JPanel();
		JPanel panId = new JPanel();
		String login = "prof";
		String password = "42";
		/*config panlogo*/
		panlogo.setBounds(50, 50, 200, 100);
		panlogo.repaint();
		panlogo.setLayout(new BorderLayout());
		JLabel image = new JLabel(new ImageIcon("./logoIUT.png"));
		panlogo.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		/*ajout au panlogo*/
		panlogo.add(image);
		
		/*config panId*/
		panId.setBounds(50, 170, 200, 250);
		panId.setBackground(Color.red);
		panId.repaint();
		panId.setLayout(null);
		panId.setBackground(new Color(247,147,201));
		panId.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		
		/*label id du panId*/
		JLabel labId = new JLabel("Identifiant:", JLabel.CENTER);
		labId.setFont(new Font("Cantarell", Font.BOLD,12));
		labId.setBounds(30, 25, 80, 15);
		
		
		/*jtextfield*/
		JTextField zonetextID = new JTextField("prof");
		zonetextID.setBounds(40, 40, 120, 25);
		
		/*label password*/
		
		JLabel labPsd = new JLabel("Mot de passe:", JLabel.CENTER);
		labPsd.setFont(new Font("Cantarell", Font.BOLD,12));
		labPsd.setBounds(39, 85, 80, 15);
		
		/*Jpassword*/
		
		JPasswordField mdp = new JPasswordField("42");
		mdp.setBounds(40, 100, 120, 25);
		
		
		/*JBoutton*/
		
		JButton valider = new JButton("Valider");
		valider.setBounds(60, 160, 80, 25);
		valider.setFont(new Font("Cantarell", Font.BOLD,12));
		valider.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (login.equals(zonetextID.getText())&& password.equals(mdp.getText())  ) {    		
					new EmploisDuTemps();
				}else{
					JOptionPane.showMessageDialog(null, "vous vous etes trompé");
					labId.resetKeyboardActions();
					labPsd.resetKeyboardActions();
				}
			}
		});
		/*ajout au panId*/
		panId.add(valider);
		panId.add(mdp);
		panId.add(labPsd);
		panId.add(labId);
		panId.add(zonetextID);
		
		/*ajout a la fenetre*/
		fen.getContentPane().add(panlogo);
		fen.getContentPane().add(panId);
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.pack();
		fen.setVisible(true);
	}
	public static void main(String[] args) {
		new Login();
	}
	
}
