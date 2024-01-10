package BoxFox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class Ablak {
	Ablak(){
	JFrame keret = new JFrame();
	JLabel panel= new JLabel();

	JLabel FelhasznaloSzoveg = new JLabel("Felhasznalo");
	JLabel PasswordSzoveg = new JLabel("Password");
	
	JTextField FelhasznaloSzovegdoboz = new JTextField(20);
	JPasswordField PasswordSzovegdoboz = new JPasswordField();
	
	JButton BejelentkezesGomb = new JButton("Bejelentkezés");
	JButton RegisztracioGomb = new JButton("Regisztráció");
	JButton KihagyasGomb = new JButton("Kihagyás");
	JButton VisszaBelepes = new JButton("Vissza");
	JButton RegisztracioVeglegesitesGomb = new JButton("Regisztráció");
	
	VisszaBelepes.setVisible(false);
	RegisztracioVeglegesitesGomb.setVisible(false);
	
	
	

	
	keret.setSize(360,250);
	keret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	keret.add(panel);
	keret.setTitle("BoxFox");
	keret.setLocation(1000, 500); //Képernyő középre kell rakni
	
	
			
	panel.setVerticalAlignment(JLabel.CENTER);
	panel.setHorizontalAlignment(JLabel.CENTER);
	 
	FelhasznaloSzovegdoboz.setBounds(110, 35, 160, 20);
	FelhasznaloSzoveg.setBounds(35, 20, 100, 50);
	PasswordSzoveg.setBounds(35, 55, 100, 50);
	PasswordSzovegdoboz.setBounds(110, 70, 160, 20);	
	
	
	BejelentkezesGomb.setBounds(120, 100, 130, 30);
	RegisztracioGomb.setBounds(40, 150, 130, 30);
	KihagyasGomb.setBounds(180, 150, 130, 30);	
	VisszaBelepes.setBounds(400,650,130,30);
	RegisztracioVeglegesitesGomb.setBounds(250, 650, 130, 30);
	
	
	
	//panel.setBackground(Color.cyan);
	
	BejelentkezesGomb.addActionListener(new ActionListener() {	
		public void actionPerformed(ActionEvent e) {
			if((FelhasznaloSzovegdoboz.getText().length()>0)&&(PasswordSzovegdoboz.getText().length()>0)) {
				System.out.print("\n\tSikeres belepes"+"\nFelhasznalo = "+FelhasznaloSzovegdoboz.getText()+"\tJelszo = "+PasswordSzovegdoboz.getText());
			}else if((FelhasznaloSzovegdoboz.getText().length()>0)){
				System.out.print("\nHianyos jelszo");
			}else if(PasswordSzovegdoboz.getText().length()>0){
				System.out.print("\nHianyos felhasznalo");
			}else {
				System.out.print("\nNincs megadott felhasznalo es jelszo paros");
			}
			
			
		}
	});
	
	
	RegisztracioGomb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.print("\nRegisztracio gomb megnyomva");
			PasswordSzoveg.setVisible(false);
			FelhasznaloSzoveg.setVisible(false);
			PasswordSzovegdoboz.setVisible(false);
			FelhasznaloSzovegdoboz.setVisible(false);
			KihagyasGomb.setVisible(false);
			RegisztracioGomb.setVisible(false);
			BejelentkezesGomb.setVisible(false);
			
			keret.setSize(800,800);
			VisszaBelepes.setVisible(true);
			RegisztracioVeglegesitesGomb.setVisible(true);
			
			
			
			
		}
	});
	
	
	KihagyasGomb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.print("\nKihagyasGomb gomb megnyomva");
			
			
		}
	});
	
	VisszaBelepes.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.print("\nVisszaBelep gomb megnyomva");
			PasswordSzoveg.setVisible(true);
			FelhasznaloSzoveg.setVisible(true);
			PasswordSzovegdoboz.setVisible(true);
			FelhasznaloSzovegdoboz.setVisible(true);
			KihagyasGomb.setVisible(true);
			RegisztracioGomb.setVisible(true);
			BejelentkezesGomb.setVisible(true);
			keret.setSize(360,250);
			
			
			
		}
	});
	
	
	
	
	
	
	
	
	panel.add(PasswordSzovegdoboz);
	panel.add(FelhasznaloSzovegdoboz);
	panel.add(FelhasznaloSzoveg);
	panel.add(PasswordSzoveg);
	panel.add(BejelentkezesGomb);
	panel.add(RegisztracioGomb);
	panel.add(KihagyasGomb);
	panel.add(VisszaBelepes);
	panel.add(RegisztracioVeglegesitesGomb);

	

	System.out.print("Ablak megnyitva");
	
	
	panel.setVisible(true);
	keret.setVisible(true);
	keret.setResizable(false);

	
	}


	public static void main(String[] args) {
		new Ablak();

	}


}
