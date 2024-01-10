package BoxFox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	
	//Belépési oldal
	JLabel FelhasznaloSzoveg = new JLabel("Felhasználónév");
	JLabel PasswordSzoveg = new JLabel("Jelszó");
	
	JTextField FelhasznaloSzovegdoboz = new JTextField();
	JPasswordField PasswordSzovegdoboz = new JPasswordField();
	
	JButton BejelentkezesGomb = new JButton("Bejelentkezés");
	JButton RegisztracioGomb = new JButton("Regisztráció");
	JButton KihagyasGomb = new JButton("Kihagyás");
	
	//Új regisztrálás oldal
	JLabel Vezeteknev = new JLabel("Vezetéknév");
	JLabel Keresztnev = new JLabel("Keresztnév");
	JLabel Email = new JLabel("E-mail cím");
	JLabel RegFelhasznalonev = new JLabel("Felhasználónév");
	JLabel RegPassword1 = new JLabel("Jelszó");
	JLabel RegPassword2 = new JLabel("Jelszó megerősítés");
	
	JTextField VezeteknevRegSzovegdoboz = new JTextField();
	JTextField KeresztnevRegSzovegdoboz = new JTextField();
	JTextField EmailRegSzovegdoboz = new JTextField();
	JTextField FelhasznaloRegSzovegdoboz = new JTextField();
	JPasswordField PasswordRegSzovegdoboz1 = new JPasswordField();
	JPasswordField PasswordRegSzovegdoboz2 = new JPasswordField();
	
	panel.add(Vezeteknev);
	panel.add(Keresztnev);
	panel.add(Email);
	panel.add(RegFelhasznalonev);
	panel.add(RegPassword1);
	panel.add(RegPassword2);
	
	Vezeteknev.setVisible(false);
	Keresztnev.setVisible(false);
	Email.setVisible(false);
	RegFelhasznalonev.setVisible(false);
	RegPassword1.setVisible(false);
	RegPassword2.setVisible(false);
	
	Vezeteknev.setBounds(230, 100, 200, 30);
	Keresztnev.setBounds(230, 135, 200, 30);
	Email.setBounds(230, 170, 200, 30);
	RegFelhasznalonev.setBounds(230, 205, 200, 30);
	RegPassword1.setBounds(230, 240, 200, 30);
	RegPassword2.setBounds(230, 275, 200, 30);
	
	Vezeteknev.setFont(new Font(null,Font.CENTER_BASELINE,16));
	Keresztnev.setFont(new Font(null,Font.CENTER_BASELINE,16));
	Email.setFont(new Font(null,Font.CENTER_BASELINE,16));
	RegFelhasznalonev.setFont(new Font(null,Font.CENTER_BASELINE,16));
	RegPassword1.setFont(new Font(null,Font.CENTER_BASELINE,16));
	RegPassword2.setFont(new Font(null,Font.CENTER_BASELINE,16));
	
	panel.add(VezeteknevRegSzovegdoboz);
	panel.add(KeresztnevRegSzovegdoboz);
	panel.add(EmailRegSzovegdoboz);
	panel.add(FelhasznaloRegSzovegdoboz);
	panel.add(PasswordRegSzovegdoboz1);
	panel.add(PasswordRegSzovegdoboz2);
	
	VezeteknevRegSzovegdoboz.setVisible(false);
	KeresztnevRegSzovegdoboz.setVisible(false);
	EmailRegSzovegdoboz.setVisible(false);
	FelhasznaloRegSzovegdoboz.setVisible(false);
	PasswordRegSzovegdoboz1.setVisible(false);
	PasswordRegSzovegdoboz2.setVisible(false);
	
	VezeteknevRegSzovegdoboz.setBounds(390, 100, 200, 30);
	KeresztnevRegSzovegdoboz.setBounds(390, 135, 200, 30);
	EmailRegSzovegdoboz.setBounds(390, 170, 200, 30);
	FelhasznaloRegSzovegdoboz.setBounds(390, 205, 200, 30);
	PasswordRegSzovegdoboz1.setBounds(390, 240, 200, 30);
	PasswordRegSzovegdoboz2.setBounds(390, 275, 200, 30);
	
	VezeteknevRegSzovegdoboz.setFont(new Font(null,Font.CENTER_BASELINE,16));
	KeresztnevRegSzovegdoboz.setFont(new Font(null,Font.CENTER_BASELINE,16));
	EmailRegSzovegdoboz.setFont(new Font(null,Font.CENTER_BASELINE,16));
	FelhasznaloRegSzovegdoboz.setFont(new Font(null,Font.CENTER_BASELINE,16));
	PasswordRegSzovegdoboz1.setFont(new Font(null,Font.CENTER_BASELINE,16));
	PasswordRegSzovegdoboz2.setFont(new Font(null,Font.CENTER_BASELINE,16));
	


	

	


	
	
	
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
	FelhasznaloSzoveg.setBounds(15, 20, 100, 50);
	PasswordSzoveg.setBounds(15, 55, 100, 50);
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
			
			Vezeteknev.setVisible(true);
			Keresztnev.setVisible(true);
			Email.setVisible(true);
			RegFelhasznalonev.setVisible(true);
			RegPassword1.setVisible(true);
			RegPassword2.setVisible(true);
			
			VezeteknevRegSzovegdoboz.setVisible(true);
			KeresztnevRegSzovegdoboz.setVisible(true);
			EmailRegSzovegdoboz.setVisible(true);
			FelhasznaloRegSzovegdoboz.setVisible(true);
			PasswordRegSzovegdoboz1.setVisible(true);
			PasswordRegSzovegdoboz2.setVisible(true);
			
			
			
			
			
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
			//Regisztráció kilépés
			Vezeteknev.setVisible(false);
			Keresztnev.setVisible(false);
			Email.setVisible(false);
			RegFelhasznalonev.setVisible(false);
			RegPassword1.setVisible(false);
			RegPassword2.setVisible(false);
			
			VezeteknevRegSzovegdoboz.setVisible(false);
			KeresztnevRegSzovegdoboz.setVisible(false);
			EmailRegSzovegdoboz.setVisible(false);
			FelhasznaloRegSzovegdoboz.setVisible(false);
			PasswordRegSzovegdoboz1.setVisible(false);
			PasswordRegSzovegdoboz2.setVisible(false);
			
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
